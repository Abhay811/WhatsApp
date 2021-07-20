package com.abhay.whatsapp.chats


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val list = mutableListOf(
            ChatList("123", "Abhay", "Hello", "19/07/2021", "alpha"),
            ChatList("124", "Abhay", "Hello", "20/07/2021", "Beta")
        )
        chatsViewModel = ViewModelProvider(this).get(ChatsViewModel::class.java)
        _binding = FragmentChatsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = ChatListAdapter(list)
        binding.rvChats.adapter = adapter
        binding.rvChats.layoutManager = LinearLayoutManager(context)


        val itemTouchHelperCallBack = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.absoluteAdapterPosition
                when(direction) {
                    ItemTouchHelper.LEFT -> {
                        binding.rvChats.removeViewAt(pos)
                        list.removeAt(pos)
                        adapter.notifyItemRemoved(pos)
                    }
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallBack)
        itemTouchHelper.attachToRecyclerView(binding.rvChats)
        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}