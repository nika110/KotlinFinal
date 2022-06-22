package com.example.imgzavredges.ui.notes.database.repository

import androidx.lifecycle.LiveData
import com.example.imgzavredges.ui.notes.database.dao.NoteDao
import com.example.imgzavredges.ui.notes.model.NoteModel

class NoteRealisation(private val noteDao: NoteDao) : NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }

    override suspend fun updateNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.update(noteModel)
        onSuccess()
    }
}