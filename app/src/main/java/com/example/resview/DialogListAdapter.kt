package com.example.resview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DialogListAdapter : RecyclerView.Adapter<DialogViewHolder>() {

    var selectedPosition = -1
        set(value) {
            if (field != -1){
                models[field].isSelected = false
                notifyItemChanged(field)
            }
            field = value
            notifyItemChanged(value)
        }

    var models: List<ModelShape> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_dialog, parent, false)
        return DialogViewHolder(item, this)
    }

    override fun onBindViewHolder(holder: DialogViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }

    override fun getItemCount(): Int = models.size
}