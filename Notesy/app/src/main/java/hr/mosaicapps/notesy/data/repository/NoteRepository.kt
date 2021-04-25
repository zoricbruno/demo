package hr.mosaicapps.notesy.data.repository

import androidx.lifecycle.LiveData
import hr.mosaicapps.notesy.model.Note

interface NoteRepository {
    fun getNotes(): LiveData<List<Note>>
    fun getNote(id: Long): Note
    fun insert(note: Note)
    fun delete(note: Note)
}