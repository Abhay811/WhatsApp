package com.abhay.whatsapp.chats


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.abhay.whatsapp.adapter.ChatListAdapter
import com.abhay.whatsapp.databinding.FragmentChatsBinding
import com.abhay.whatsapp.model.ChatList


class ChatsFragment : Fragment() {

    private lateinit var chatsViewModel: ChatsViewModel
    private var _binding: FragmentChatsBinding? = null

    // This property is only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var list = mutableListOf(
            ChatList("123", "Abhay", "Hello", "19/07/2021", "alpha")
        )
        chatsViewModel = ViewModelProvider(this).get(ChatsViewModel::class.java)
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = ChatListAdapter(list)
        binding.rvChats.adapter = adapter
        binding.rvChats.layoutManager = LinearLayoutManager(context)


        return root

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}