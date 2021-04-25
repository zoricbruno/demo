package hr.mosaicapps.notesy.ui.noteslist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.mosaicapps.notesy.R
import hr.mosaicapps.notesy.databinding.ActivityNotesBinding
import hr.mosaicapps.notesy.ui.noteslist.fragments.NoteDetailsFragment
import hr.mosaicapps.notesy.ui.noteslist.fragments.NoteListFragment
import hr.mosaicapps.notesy.ui.noteslist.OnNoteSelectedListener
import hr.mosaicapps.notesy.model.Note
import hr.mosaicapps.notesy.ui.newnote.activities.NewNoteActivity

class NotesActivity
    : AppCompatActivity(), OnNoteSelectedListener {

    private lateinit var binding: ActivityNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotesBinding.inflate(layoutInflater)
        binding.fabAddNote.setOnClickListener{createNewNote()}
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, NoteListFragment.create(), NoteListFragment.TAG)
                .commit()
        }
    }

    private fun createNewNote() {
        val newNoteIntent = Intent(this, NewNoteActivity::class.java)
        startActivity(newNoteIntent)
    }

    override fun OnNoteSelected(note: Note) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_fragmentContainer,
                NoteDetailsFragment.create(note),
                NoteDetailsFragment.TAG)
            .addToBackStack(null)
            .commit()
    }
}