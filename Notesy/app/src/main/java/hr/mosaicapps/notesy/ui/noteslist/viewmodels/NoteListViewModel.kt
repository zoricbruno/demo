package hr.mosaicapps.notesy.ui.noteslist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import hr.mosaicapps.notesy.data.repository.NoteRepository
import hr.mosaicapps.notesy.model.Note

class NoteListViewModel(
    private val repository: NoteRepository
): ViewModel() {

    val notes: LiveData<List<Note>> = repository.getNotes()
}