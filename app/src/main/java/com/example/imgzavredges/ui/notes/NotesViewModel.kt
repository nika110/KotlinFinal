package com.example.imgzavredges.ui.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.imgzavredges.ui.notes.database.NotesDatabase
import com.example.imgzavredges.ui.notes.database.repository.NoteRealisation
import com.example.imgzavredges.ui.notes.model.NoteModel
import com.example.imgzavredges.utils.REPOSITORY
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {
    private val context = application

    fun initDatabase(){
        val daoNote = NotesDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealisation(daoNote)
    }

    fun delete(noteModel: NoteModel){
        viewModelScope.launch {
            REPOSITORY.deleteNote(noteModel) {}
        }
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }
}