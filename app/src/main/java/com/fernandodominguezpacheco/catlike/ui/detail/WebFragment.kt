package com.fernandodominguezpacheco.catlike.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.fernandodominguezpacheco.catlike.databinding.FragmentWebBinding
import com.fernandodominguezpacheco.catlike.utils.SharedViewModel
import com.fernandodominguezpacheco.miningmarket.observer
import kotlinx.android.synthetic.main.fragment_web.*


class WebFragment : Fragment() {

    private val sharedViewModel : SharedViewModel by activityViewModels()
    private var _binding: FragmentWebBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            webView.webChromeClient = object : WebChromeClient(){
            }
            webView.webViewClient = object : WebViewClient(){
            }
        }
        observer(sharedViewModel.getSelectedBreed()){
            webView.loadUrl(it.wikipedia_url)
            binding.breedName.text = it.name
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}