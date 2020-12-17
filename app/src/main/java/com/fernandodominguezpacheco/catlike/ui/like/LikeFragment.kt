package com.fernandodominguezpacheco.catlike.ui.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fernandodominguezpacheco.catlike.databinding.FragmentLikeBinding
import com.fernandodominguezpacheco.miningmarket.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LikeFragment : Fragment() {

    private val likeViewModel: LikeViewModel by viewModels()
    private var _binding: FragmentLikeBinding?= null
    private val binding get() = _binding!!
    private val adapter = LikeAdapter{}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLikeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        observer(likeViewModel.likeItems){
            adapter.items = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}