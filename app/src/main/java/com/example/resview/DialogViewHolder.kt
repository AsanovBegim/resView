package com.example.resview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_dialog.view.*

class DialogViewHolder(itemView: View, private val adapter: DialogListAdapter) : RecyclerView.ViewHolder(itemView) {

    fun populateModel(model: ModelShape, pos: Int){
        itemView.numbers.text = model.number.toString()
        if (model.isSelected){
            itemView.shape.setImageResource(R.drawable.shape_bg)
        }
        itemView.setOnClickListener {
            model.isSelected = true
            adapter.selectedPosition = pos
        }
    }
}