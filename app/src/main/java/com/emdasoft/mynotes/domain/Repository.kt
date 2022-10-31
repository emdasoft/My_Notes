package com.emdasoft.mynotes.domain

import androidx.lifecycle.MutableLiveData

interface Repository {

    fun addNoteItem(noteItem: NoteItem)

    fun deleteNoteItem(noteItem: NoteItem)

    fun editNoteItem(noteItem: NoteItem)

    fun showNoteItemList() : MutableLiveData<List<NoteItem>>

    fun getNoteItem(id: Int) : NoteItem

}