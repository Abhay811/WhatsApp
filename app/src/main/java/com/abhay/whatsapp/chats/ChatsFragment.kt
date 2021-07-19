package com.abhay.whatsapp.chats


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.abhay.whatsapp.databinding.FragmentChatsBinding


class ChatsFragment : Fragment() {

    private lateinit var chatsViewModel: ChatsViewModel
    private var _binding: FragmentChatsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        chatsViewModel = ViewModelProvider(this).get(ChatsViewModel::class.java)
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val texView: TextView = binding.textChats
        chatsViewModel.text.observe(viewLifecycleOwner, {
            texView.text = it
        })

        return root

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}