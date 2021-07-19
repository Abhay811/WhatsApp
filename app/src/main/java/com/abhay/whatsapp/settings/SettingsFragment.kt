package com.abhay.whatsapp.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.abhay.whatsapp.chats.ChatsViewModel
import com.abhay.whatsapp.databinding.FragmentChatsBinding
import com.abhay.whatsapp.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel
    private var _binding: FragmentSettingsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        settingsViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val texView: TextView = binding.textSettings
        settingsViewModel.text.observe(viewLifecycleOwner, {
            texView.text = it
        })

        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}