package hr.mosaicapps.notesy.data

import hr.mosaicapps.notesy.model.Note

object NotesRepository {

    private val notes = mutableListOf<Note>(
        Note("RMA","Slušaj gradivo", 1),
        Note("RMA","Nađi git", 2),
        Note("Digitalna videotehnika","Padni kolokvij", 3),
        Note("RMA","Riješi zadaću", 2),
        Note("Objektno","Baci iznimku", 3),
    )

    fun getNotes(): List<Note> = notes
    fun insert(note: Note) = notes.add(note)
}