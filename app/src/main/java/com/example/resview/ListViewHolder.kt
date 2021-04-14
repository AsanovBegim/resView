package com.example.resview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun populateModel(user: User, onClick: (view: View, position: Int) -> Unit, position: Int) {
        val tvTitle: TextView = itemView.tvTitle
        val tvDescription: TextView = itemView.tvDescription
        tvTitle.text = user.title
        tvDescription.text = user.description
        itemView.btn3.setOnClickListener{
            onClick.invoke(it, position)
        }
    }
}