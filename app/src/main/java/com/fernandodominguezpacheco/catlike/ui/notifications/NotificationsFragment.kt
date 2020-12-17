package com.fernandodominguezpacheco.catlike.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.fernandodominguezpacheco.catlike.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private val notificationsViewModel: NotificationsViewModel by viewModels()
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNotificationsBinding.inflate(layoutInflater)

        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotifications.text = it
        })
        return binding.root
    }
}