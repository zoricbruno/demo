package hr.mosaicapps.notesy.ui.newnote.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.mosaicapps.notesy.databinding.ActivityNewNoteBinding
import hr.mosaicapps.notesy.ui.newnote.viewmodels.NewNoteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewNoteBinding
    private val viewModel by viewModel<NewNoteViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        binding.bNewNoteSave.setOnClickListener{saveNote()}
        setContentView(binding.root)
    }

    private fun saveNote() {
        binding.apply {
            val title = etNewNoteTitleInput.text.toString()
            val details = etNewNoteDetailsInput.text.toString()
            val priority = etNewNotePriorityInput.text.toString().toInt()
            viewModel.saveNote(title, details, priority)
        }
        finish()
    }
}