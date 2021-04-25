package hr.mosaicapps.notesy.ui.noteslist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.mosaicapps.notesy.databinding.FragmentNoteDetailsBinding
import hr.mosaicapps.notesy.utilities.mapPriorityToColorResource
import hr.mosaicapps.notesy.model.Note

class NoteDetailsFragment : Fragment() {

    lateinit var binding: FragmentNoteDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteDetailsBinding.inflate(
            inflater,
            container,
            false
        )

        arguments?.let {
            val note = it.getSerializable(KEY_NOTE) as Note
            binding.tvNoteTitle.text = note.title
            binding.ivNotePriority.setBackgroundResource(
                mapPriorityToColorResource(note.priority))
            binding.tvNoteDetails.text = note.details
        }

        return binding.root
    }

    companion object{

        const val TAG = "Details"
        private const val KEY_NOTE = "Note"

        fun create(note: Note): NoteDetailsFragment {
            val args = Bundle()
            args.putSerializable(KEY_NOTE, note)
            val fragment = NoteDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}