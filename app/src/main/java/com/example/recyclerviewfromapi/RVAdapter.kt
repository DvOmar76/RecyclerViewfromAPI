package com.example.recyclerviewfromapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*
import java.util.*

class RVAdapter(val names:ArrayList<DataItem>):RecyclerView.Adapter<RVAdapter.RVHolder>(){
    class RVHolder (itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.RVHolder {
        return RVHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.item_row,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RVAdapter.RVHolder, position: Int) {
        holder.itemView.apply {
            textView.text=names[position].name
        }

    }

    override fun getItemCount()=names.size

}