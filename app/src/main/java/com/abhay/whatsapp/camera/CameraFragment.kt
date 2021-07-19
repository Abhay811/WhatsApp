package com.abhay.whatsapp.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.abhay.whatsapp.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {


    private lateinit var cameraViewModel: CameraViewModel
    private var _binding: FragmentCameraBinding? = null


    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        cameraViewModel = ViewModelProvider(this).get(CameraViewModel::class.java)
        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val texView: TextView = binding.textCamera
        cameraViewModel.text.observe(viewLifecycleOwner, {
            texView.text = it
        })

        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}