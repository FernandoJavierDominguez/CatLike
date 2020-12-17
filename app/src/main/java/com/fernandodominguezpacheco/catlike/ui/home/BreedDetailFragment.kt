package com.fernandodominguezpacheco.catlike.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.fernandodominguezpacheco.catlike.R
import com.fernandodominguezpacheco.catlike.databinding.FragmentBreedDetailBinding
import com.fernandodominguezpacheco.catlike.databinding.FragmentHomeBinding
import com.fernandodominguezpacheco.catlike.utils.SharedViewModel
import com.fernandodominguezpacheco.miningmarket.loadUrl
import com.fernandodominguezpacheco.miningmarket.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedDetailFragment : Fragment() {

    private var _binding: FragmentBreedDetailBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBreedDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observer(sharedViewModel.getSelectedBreed()){
            with(binding){
                url.loadUrl(it.url)
                name.text = it.name
                description.text = it.description
                origin.text = it.origin
                temperament.text = it.temperament
                wikipediaUrl.text = it.wikipedia_url
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}