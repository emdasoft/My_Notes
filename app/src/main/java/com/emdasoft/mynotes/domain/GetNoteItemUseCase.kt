package com.emdasoft.mynotes.domain

class GetNoteItemUseCase(private val repository: Repository) {

    fun getNoteItem(id: Int): NoteItem {

        return repository.getNoteItem(id)

    }
}