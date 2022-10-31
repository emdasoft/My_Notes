package com.emdasoft.mynotes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emdasoft.mynotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private lateinit var noteListAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecycler()


        viewModel.noteList.observe(this) {
            Log.d("MyList", "$it")
            noteListAdapter.notesList = it
        }

    }

    private fun setupRecycler() {
        binding.noteRecycler.layoutManager = LinearLayoutManager(this)
        noteListAdapter = MainAdapter()
        binding.noteRecycler.adapter = noteListAdapter

        setupOnClickListener()

        setupOnSwipeListener()
    }

    private fun setupOnSwipeListener() {
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val item = noteListAdapter.notesList[viewHolder.bindingAdapterPosition]
                viewModel.deleteNote(item)
            }

        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.noteRecycler)
    }

    private fun setupOnClickListener() {
        noteListAdapter.onNoteClickListener = {
            Toast.makeText(this, "This is ${it.id} !", Toast.LENGTH_SHORT).show()
        }
    }

}