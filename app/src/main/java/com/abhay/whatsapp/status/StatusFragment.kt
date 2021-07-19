package com.abhay.whatsapp.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.abhay.whatsapp.R
import com.abhay.whatsapp.camera.CameraViewModel
import com.abhay.whatsapp.databinding.FragmentCameraBinding
import com.abhay.whatsapp.databinding.FragmentStatusBinding


class StatusFragment : Fragment() {

    private lateinit var statusViewModel: StatusViewModel
    private var _binding: FragmentStatusBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        statusViewModel = ViewModelProvider(this).get(StatusViewModel::class.java)
        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val texView: TextView = binding.textStatus
        statusViewModel.text.observe(viewLifecycleOwner, {
            texView.text = it
        })

        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}