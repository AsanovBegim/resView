package com.example.resview

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.custom_dialog.*

class CustomDialog(context: Context) : Dialog(context) {

    private val adapter = DialogListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        recyler1.adapter = adapter
        setData()
    }

    private fun setData(){
        val numbers: MutableList<ModelShape> = mutableListOf()
        for (i in 1 .. 100){
            numbers.add(ModelShape(i, false))
        }
        adapter.models = numbers
    }
}