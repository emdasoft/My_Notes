package com.emdasoft.mynotes.domain

class DeleteNoteItemUseCase(private val repository: Repository) {

    fun deleteNoteItem(noteItem: NoteItem) {

        repository.deleteNoteItem(noteItem)

    }
}