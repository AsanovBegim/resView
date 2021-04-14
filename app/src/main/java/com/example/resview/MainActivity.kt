package com.example.resview

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter = ListAdapter()

    private val models: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData()
//        adapter.onClick = {
//            for (i in 0 .. it) {
//                val model = User()
//                model.title = "Title ${i+it+2}"
//                model.description = "Description ${i+it+2}"
//                models.add(model)
//                adapter.setData(models)
//            }
//        }
        adapter.setOnOptionsClickListener { view: View, position: Int ->
            this.setOnOptions(view, position)
        }
    }

    private fun setData() {
        val model = User("Title", "Description")
        model.title = "Title 1"
        model.description = "Description 1"
        models.add(model)
        adapter.setData(models)
    }

    private fun setOnOptions(view: View, position: Int) {
        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.item_options, optionsMenu.menu)
        optionsMenu.show()
        optionsMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.itemAdd -> {
                    val dialog = CustomDialog(this)
                    dialog.show()
                }
                R.id.itemDelete -> {
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Уверены??")
                        .setMessage("Обратного пути уже не будет!?")
                        .setPositiveButton("Да") { _, _ ->
                            adapter.delete(position)
                        }
                        .setNegativeButton("Нет") { dialog, _ ->
                            dialog.dismiss()
                        }
                    dialog.show()
                }
            }
            return@setOnMenuItemClickListener true
        }
    }
}