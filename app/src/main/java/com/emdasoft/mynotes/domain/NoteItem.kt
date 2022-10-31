package com.emdasoft.mynotes.domain

data class NoteItem(
    val title: String,
    var description: String,
    var priority: Int = DEFAULT_PRIORITY,
    var id: Int = UNDEFINED_ID,
) {
    companion object {
        const val UNDEFINED_ID = -1
        const val DEFAULT_PRIORITY = 0
    }
}
