package hr.mosaicapps.notesy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import hr.mosaicapps.notesy.R

import hr.mosaicapps.notesy.data.NotesRepository
import hr.mosaicapps.notesy.databinding.FragmentNoteListBinding
import hr.mosaicapps.notesy.databinding.ItemNoteBinding
import hr.mosaicapps.notesy.helpers.getColorResource
import hr.mosaicapps.notesy.model.Note

class NoteListFragment : Fragment() {

    lateinit var fragmentBinding: FragmentNoteListBinding
    val repository = NotesRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBinding = FragmentNoteListBinding.inflate(
            inflater, container, false
        )
        fragmentBinding.rvNotes.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        fragmentBinding.rvNotes.adapter = NotesAdapter(repository.getNotes())
        return fragmentBinding.root
    }

    companion object {
        fun create(): NoteListFragment {
            return NoteListFragment()
        }
    }

    inner class NotesAdapter(
        private val notes: List<Note>
    ) :
        RecyclerView.Adapter<NotesViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_note, parent, false)
            return NotesViewHolder(view)
        }

        override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
            val note = notes[position]
            holder.bind(note)
        }

        override fun getItemCount(): Int {
            return notes.size
        }
    }

    inner class NotesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) {
            val itemBinding = ItemNoteBinding.bind(itemView)
            itemBinding.tvNoteItemTitle.text = note.title
            itemBinding.ivNoteItemImportance.setBackgroundResource(
                getColorResource(note.importance)
            )
        }
    }
}