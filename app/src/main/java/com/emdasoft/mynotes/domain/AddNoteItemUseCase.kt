package com.emdasoft.mynotes.domain

class AddNoteItemUseCase(private val repository: Repository) {

    fun addNoteItem(noteItem: NoteItem) {

        repository.addNoteItem(noteItem)

    }
}