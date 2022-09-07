package com.example.listapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.databinding.ItemBinding

class ListAdapter(
    val listItem: MutableList<ListItem>,
    val listener: ListAdapterListener

    ): RecyclerView.Adapter<ListAdapter.ListItemViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        return ListItemViewHolder (
            ItemBinding.inflate(LayoutInflater.from(parent.context),
        parent,
        false
            ))


    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) { // viculacao, para poder exibir na tela
        val item = listItem[position]
       holder.posicao.text = position.toString()
        holder.conteudo.text = item.city

        holder.root.setOnClickListener {
            listener.onItemCliccked(item.city)
        }
    }

    override fun getItemCount(): Int { // diz quantos elementos vai ter na tela
        return listItem.size
    }

    class ListItemViewHolder(binding:ItemBinding): RecyclerView.ViewHolder(binding.root){
        var root = binding.root
        var posicao= binding.posicao
        var conteudo = binding.conteudo

    }
    interface ListAdapterListener{
        fun onItemCliccked(content: String);
    }
}