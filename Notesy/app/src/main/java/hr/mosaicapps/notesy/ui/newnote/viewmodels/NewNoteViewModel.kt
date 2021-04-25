package hr.mosaicapps.notesy.ui.newnote.viewmodels

import androidx.lifecycle.ViewModel
import hr.mosaicapps.notesy.data.repository.NoteRepository
import hr.mosaicapps.notesy.model.Note

class NewNoteViewModel(
    private val repository: NoteRepository
) : ViewModel(){

    fun saveNote(title: String, details: String, priority: Int){
        val note = Note(0, title, details, priority)
        repository.insert(note)
    }
}