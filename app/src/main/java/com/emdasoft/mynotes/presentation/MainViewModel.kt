package com.emdasoft.mynotes.presentation

import androidx.lifecycle.ViewModel
import com.emdasoft.mynotes.data.RepositoryImpl
import com.emdasoft.mynotes.domain.DeleteNoteItemUseCase
import com.emdasoft.mynotes.domain.NoteItem
import com.emdasoft.mynotes.domain.ShowNoteItemListUseCase

class MainViewModel : ViewModel() {

    private val repository = RepositoryImpl

    private val showNoteItemListUseCase = ShowNoteItemListUseCase(repository)
    private val deleteNoteItemUseCase = DeleteNoteItemUseCase(repository)

    val noteList = showNoteItemListUseCase.showNoteItemList()

    fun deleteNote(noteItem: NoteItem) {
        deleteNoteItemUseCase.deleteNoteItem(noteItem)
    }

}