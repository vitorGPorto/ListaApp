package com.example.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),ListAdapter.ListAdapterListener {
    private lateinit var binding: ActivityMainBinding

    private val itemList: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.lista

        creatMockData()

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter= ListAdapter(itemList,this)
    }

    private fun creatMockData(){
        itemList.add(ListItem("Porto Alegre","RS"))
        itemList.add(ListItem("Belo Horizonte","MG"))
        itemList.add(ListItem("Curitiba","RR"))
        itemList.add(ListItem("São Paulo","SP"))
        itemList.add(ListItem("Rio de Janeiro","RJ"))
        itemList.add(ListItem("Salvador","BA"))
        itemList.add(ListItem("Bélem","PA"))
        itemList.add(ListItem("Palmas","TO"))
    }
    override fun onItemCliccked(content: String) {
       Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT).show()
    }


}