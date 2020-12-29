package com.fernandodominguezpacheco.catlike.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.fernandodominguezpacheco.catlike.R
import com.fernandodominguezpacheco.catlike.databinding.FragmentBreedDetailBinding
import com.fernandodominguezpacheco.catlike.utils.SharedViewModel
import com.fernandodominguezpacheco.miningmarket.loadUrl
import com.fernandodominguezpacheco.miningmarket.observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BreedDetailFragment : Fragment() {

    private var _binding: FragmentBreedDetailBinding? = null
    private val binding get() = _binding!!

    private val breedDetailViewModel: BreedDetailViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBreedDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var breedId: String
        var likeResult: Boolean = false
        observer(sharedViewModel.getSelectedBreed()){
            with(binding){
                url.loadUrl(it.url)
                name.text = it.name
                description.text = it.description
                origin.text = it.origin
                temperament.text = it.temperament
                wikipediaUrl.text = it.wikipedia_url
                if(it.likes.isEmpty()) like.setImageResource(R.drawable.ic_favorite_border) else like.setImageResource(R.drawable.ic_favorite)
                likeResult = it.likes.isNotEmpty()
                breedId = it.id

            }
        }
        binding.button.setOnClickListener {
            it.findNavController().navigate(R.id.action_navigation_detail_to_navigation_web)
        }
        binding.like.setOnClickListener {
            likeResult = if(likeResult){
                breedDetailViewModel.deleteLike(breedId)
                binding.like.setImageResource(R.drawable.ic_favorite_border)
                false
            } else{
                breedDetailViewModel.addLike(breedId)
                binding.like.setImageResource(R.drawable.ic_favorite)
                true
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

