package com.fernandodominguezpacheco.catlike.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.fernandodominguezpacheco.catlike.R
import com.fernandodominguezpacheco.catlike.databinding.FragmentHomeBinding
import com.fernandodominguezpacheco.catlike.utils.SharedViewModel
import com.fernandodominguezpacheco.miningmarket.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val breedViewModel: BreedViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val adapter = BreedAdapter{
        sharedViewModel.selectBreed(it)
        requireView().findNavController().navigate(R.id.action_navigation_home_to_navigation_detail)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(context, 2)
        observer(breedViewModel.breedItems){
            adapter.items = it
        }
        swipeRefreshLayout = binding.swipeRefreshLayout
        swipeRefreshLayout.setOnRefreshListener {
            breedViewModel.getBreeds()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}