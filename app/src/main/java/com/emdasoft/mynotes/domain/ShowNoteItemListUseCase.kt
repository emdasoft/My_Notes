package com.emdasoft.mynotes.domain

import androidx.lifecycle.MutableLiveData

class ShowNoteItemListUseCase(private val repository: Repository) {

    fun showNoteItemList(): MutableLiveData<List<NoteItem>> {

        return repository.showNoteItemList()

    }
}