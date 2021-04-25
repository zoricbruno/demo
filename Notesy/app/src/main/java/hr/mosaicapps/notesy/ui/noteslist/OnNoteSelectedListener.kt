package hr.mosaicapps.notesy.ui.noteslist

import hr.mosaicapps.notesy.model.Note

interface OnNoteSelectedListener {
    fun OnNoteSelected(note: Note)
}