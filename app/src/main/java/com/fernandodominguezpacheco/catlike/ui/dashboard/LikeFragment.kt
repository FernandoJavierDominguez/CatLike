package com.fernandodominguezpacheco.catlike.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.fernandodominguezpacheco.catlike.databinding.FragmentDashboardBinding

class LikeFragment : Fragment() {

    private val dashboardViewModel: LikeViewModel by viewModels()
    private var _binding: FragmentDashboardBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDashboardBinding.inflate(layoutInflater)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textDashboard.text = it
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}