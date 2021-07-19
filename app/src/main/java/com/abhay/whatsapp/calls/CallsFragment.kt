package com.abhay.whatsapp.calls

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.abhay.whatsapp.databinding.FragmentCallsBinding


class CallsFragment : Fragment() {

    private lateinit var callsViewModel: CallsViewModel
    private var _binding: FragmentCallsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        callsViewModel = ViewModelProvider(this).get(CallsViewModel::class.java)
        _binding = FragmentCallsBinding.inflate(inflater, container, false)

        val root: View = binding.root
        val texView: TextView = binding.textCalls
        callsViewModel.text.observe(viewLifecycleOwner, {
            texView.text = it
        })

        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}