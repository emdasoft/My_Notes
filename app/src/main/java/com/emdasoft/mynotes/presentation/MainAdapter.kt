package com.emdasoft.mynotes.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emdasoft.mynotes.R
import com.emdasoft.mynotes.databinding.NoteItemBinding
import com.emdasoft.mynotes.domain.NoteItem

class MainAdapter : RecyclerView.Adapter<MainAdapter.NoteViewHolder>() {

    var notesList = emptyList<NoteItem>()
        set(value) {
            val callback = NoteListDiffCallback(notesList, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    private var count = 0

    var onNoteClickListener: ((NoteItem) -> Unit)? = null

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = NoteItemBinding.bind(itemView)

        private val backgrounds = listOf(R.color.top, R.color.middle, R.color.low)

        fun bind(noteItem: NoteItem) = with(binding) {

            when (noteItem.priority) {
                0 -> {
                    starPriority.setBackgroundResource(backgrounds[2])
                }
                1 -> {
                    starPriority.setBackgroundResource(backgrounds[1])
                }
                2 -> {
                    starPriority.setBackgroundResource(backgrounds[0])
                }
            }
            idOfNote.text = buildString {
                append("#")
                append(noteItem.id.toString())
            }
            title.text = noteItem.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        Log.d("MyAdapter", "${++count}")
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.note_item,
            parent,
            false
        )
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notesList[position])
        holder.itemView.setOnClickListener {
            onNoteClickListener?.invoke(notesList[position])
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

}