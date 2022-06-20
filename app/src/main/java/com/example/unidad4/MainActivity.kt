
package com.example.unidad4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.unidad4.adapters.CharacterAdapter
import com.example.unidad4.databinding.ActivityMainBinding
import com.example.unidad4.models.Character

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:MainActivityViewModel

    private var adapter:CharacterAdapter? = null

    private var itemCallback = object  : ItemTouchHelper.SimpleCallback(
        0,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            viewModel.delete(position)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inicializa
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContentView(binding.root)

        viewModel.characters.observe(this){
            setupList(it)
        }
        viewModel.getCharacters()
    }
    private fun setupList(list: List<Character>){
        if (adapter == null) {
            adapter = CharacterAdapter(list)
            binding.lista.adapter = adapter
            ItemTouchHelper(itemCallback)
                .attachToRecyclerView(binding.lista)
        } else {
            adapter!!.notifyDataSetChanged()
        }
    }

}

//primera forma de hacer suaip
//class ItemCollback : ItemTouchHelper.SimpleCallback(){
//    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//        TODO("Not yet implemented")
//    }
//
//}