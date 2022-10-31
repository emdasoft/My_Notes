package com.emdasoft.mynotes.data

import androidx.lifecycle.MutableLiveData
import com.emdasoft.mynotes.domain.NoteItem
import com.emdasoft.mynotes.domain.Repository
import kotlin.random.Random

object RepositoryImpl : Repository {


    private val noteList = mutableListOf<NoteItem>()
    private val noteListLD = MutableLiveData<List<NoteItem>>()

    private var autoIncrementID = 0

    init {
        for (item in 0..1000) {
            addNoteItem(NoteItem("item", "Description",  Random.nextInt(0, 3) ))
        }
    }

    override fun addNoteItem(noteItem: NoteItem) {
        if (noteItem.id == NoteItem.UNDEFINED_ID) {
            noteItem.id = autoIncrementID++
        }
        noteList.add(noteItem)
        updateList()
    }

    override fun deleteNoteItem(noteItem: NoteItem) {
        noteList.remove(noteItem)
        updateList()
    }

    override fun editNoteItem(noteItem: NoteItem) {
        val oldItem = getNoteItem(noteItem.id)
        deleteNoteItem(oldItem)
        addNoteItem(noteItem)
        updateList()
    }

    override fun showNoteItemList(): MutableLiveData<List<NoteItem>> {
        return noteListLD
    }

    override fun getNoteItem(id: Int): NoteItem {
        return noteList.find {
            it.id == id
        } ?: throw RuntimeException("Element with id $id not found!")

    }

    private fun updateList() {
        noteListLD.value = noteList.toList()
    }
}