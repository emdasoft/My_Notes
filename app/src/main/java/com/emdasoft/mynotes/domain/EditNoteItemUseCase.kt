package com.emdasoft.mynotes.domain

class EditNoteItemUseCase(private val repository: Repository) {

    fun editNoteItem(noteItem: NoteItem) {

        repository.editNoteItem(noteItem)

    }
}