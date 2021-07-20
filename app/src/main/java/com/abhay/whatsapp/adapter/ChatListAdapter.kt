package com.abhay.whatsapp.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abhay.whatsapp.R
import com.abhay.whatsapp.model.ChatList
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target

class MyAdapter(var context: Context, itemList: List<ChatList>) :
    RecyclerView.Adapter<MyViewHolder>() {
    var itemList: List<ChatList>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(itemList[position].getImage())
            .into<Target<Drawable>>(holder.cart_item_img)
        holder.cart_item_name.setText(itemList[position].getPrice())
        holder.cart_item_price.setText(itemList[position].getPrice())
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    init {
        this.itemList = itemList
    }
}
