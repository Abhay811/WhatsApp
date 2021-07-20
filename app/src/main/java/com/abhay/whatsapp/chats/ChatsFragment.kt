package com.abhay.whatsapp.chats


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhay.whatsapp.R
import com.abhay.whatsapp.adapter.ChatListAdapter
import com.abhay.whatsapp.databinding.FragmentChatsBinding
import com.abhay.whatsapp.helper.MyButtonClickListener
import com.abhay.whatsapp.helper.MySwipeHelper
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
        val recyclerView = binding.rvChats
        recyclerView.setHasFixedSize(true)

        val swipeHelper: MySwipeHelper = object : MySwipeHelper(this, recyclerView, 200) {
            override fun instantiateMyButton(
                viewHolder: RecyclerView.ViewHolder?,
                buffer: MutableList<MyButton>?
            ) {
                buffer?.add(
                    MyButton(this,
                        "Delete",
                        R.drawable.ic_archive,
                        10,
                        Color.parseColor("#ff3c30"),
                        object : MyButtonClickListener {
                            override fun onClick(pos: Int) {
                                //                                Toast.makeText(
                                //                                    this,
                                //                                    "Delete Clicked",
                                //                                    Toast.LENGTH_LONG
                                //                                ).show()
                                Log.d("Main", "Delete Clicked")
                            }
                        })
                )
                buffer?.add(
                    MyButton(this,
                        "Update", R.drawable.ic_baseline_more_horiz_24, 10, Color.parseColor("#ff9502"),
                        object : MyButtonClickListener {
                            override fun onClick(pos: Int) {
//                                Toast.makeText(
//                                    this@MainActivity,
//                                    "Update Clicked",
//                                    Toast.LENGTH_LONG
//                                ).show()
                                Log.d("Main", "Update Clicked")
                            }
                        })
                )
            }


        }

        return root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}