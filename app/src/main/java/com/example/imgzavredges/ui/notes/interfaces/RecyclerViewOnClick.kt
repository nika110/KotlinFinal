package com.example.imgzavredges.ui.notes.interfaces

import com.example.imgzavredges.ui.notes.model.NoteModel

interface RecyclerViewOnClick {
    fun onRecyclerViewLongClick(notesModel: NoteModel)
    fun onRecyclerViewClick(notesModel: NoteModel)
}
