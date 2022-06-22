package com.example.imgzavredges.ui.notes.notesFragments.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imgzavredges.ui.notes.model.NoteModel
import com.example.imgzavredges.utils.REPOSITORY
import kotlinx.coroutines.launch

class AddNotesViewModel: ViewModel() {
    fun insert(noteModel: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch {
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }
}