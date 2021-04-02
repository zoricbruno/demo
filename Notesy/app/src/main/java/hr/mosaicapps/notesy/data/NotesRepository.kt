package hr.mosaicapps.notesy.data

import hr.mosaicapps.notesy.model.Note

object NotesRepository {

    private val notes = mutableListOf<Note>(
        Note("Enjoy the sun", "Drink coffee", 1),
        Note("Go to a party", "Drink beer", 1),
        Note("Read a book", "Clean code", 2),
        Note("Ride bike", "At least 10km", 3),
        Note("Buy groceries", "Bread, milk, cheese", 1),
    )

    fun getNotes(): List<Note> = notes
    fun getNote(title: String): Note = notes.first { it -> it.title == title }
    fun insert(note: Note) = notes.add(note)
    fun delete(note: Note) = notes.remove(note)
}