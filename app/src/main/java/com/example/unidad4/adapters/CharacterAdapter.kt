package com.example.unidad4.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.unidad4.databinding.ItemListBinding
import com.example.unidad4.models.Character

class CharacterAdapter(
    private val list:List<Character>
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    inner class CharacterViewHolder(val binding:ItemListBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = list[position]
        holder.binding.titulo.text = character.name
        holder.binding.subTitulo.text = character.species
        holder.binding.imageView.load(character.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
