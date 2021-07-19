package com.abhay.whatsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhay.whatsapp.R
import com.abhay.whatsapp.databinding.LayoutChatListBinding
import com.abhay.whatsapp.model.ChatList

class ChatListAdapter(
    var chatList: List<ChatList>
) : RecyclerView.Adapter<ChatListAdapter.ChatViewHolder>() {

    private var _binding: LayoutChatListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_chat_list, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.itemView.apply {
            
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}