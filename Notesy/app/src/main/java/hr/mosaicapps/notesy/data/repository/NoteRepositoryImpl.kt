package hr.mosaicapps.notesy.data.repository

import androidx.lifecycle.LiveData
import hr.mosaicapps.notesy.data.database.NoteDao
import hr.mosaicapps.notesy.model.Note

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {
    override fun getNotes(): LiveData<List<Note>> = noteDao.getNotes()
    override fun getNote(id: Long): Note = noteDao.getNote(id)
    override fun insert(note: Note) = noteDao.insert(note)
    override fun delete(note: Note) = noteDao.delete(note)
}