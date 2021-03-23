package hr.mosaicapps.notesy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.mosaicapps.notesy.databinding.FragmentNoteDetailsBinding
import hr.mosaicapps.notesy.helpers.getColorResource
import hr.mosaicapps.notesy.model.Note

class NoteDetailsFragment : Fragment() {

    lateinit var binding: FragmentNoteDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailsBinding.inflate(
            inflater,
            container,
            false
        )
        val  note = arguments!!.getSerializable(KEY_NOTE) as Note

        binding.tvNoteTitle.text = note.title
        binding.ivNoteImportance.setBackgroundResource(
            getColorResource(note.importance))
        binding.tvNoteDescription.text = note.description

        return binding.root
    }

    companion object{

        private const val KEY_NOTE = "note"

        fun create(note: Note): NoteDetailsFragment {
            val args = Bundle()
            args.putSerializable(KEY_NOTE, note)
            val fragment = NoteDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}