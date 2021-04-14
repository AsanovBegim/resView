package com.example.resview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private var models: MutableList<User> = mutableListOf()

    fun setData(data: MutableList<User>) {
        models = data
        notifyDataSetChanged()
    }

    private var setOnClick: (view: View, position: Int) -> Unit = { _: View, _: Int -> }
    fun setOnOptionsClickListener(setOnClick: (view: View, position: Int) -> Unit) {
        this.setOnClick = setOnClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListViewHolder(itemView)
    }

//    fun add(position: Int, title: String, description: String) {
//        models.add(User(title, description))
//        notifyItemInserted(models.size - 1)
//    }

    fun delete(position: Int) {
        models.remove(models.removeAt(position))
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModel(models[position], setOnClick, position)
    }


}