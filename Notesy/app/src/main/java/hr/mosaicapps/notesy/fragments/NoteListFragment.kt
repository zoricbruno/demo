package hr.mosaicapps.notesy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
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

    lateinit var binding: FragmentNoteListBinding
    val repository = NotesRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteListBinding.inflate(
            inflater, container, false
        )
        binding.rvNotes.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.rvNotes.adapter = NotesAdapter(repository.getNotes())
        return binding.root
    }

    companion object{
        fun create(): NoteListFragment{
            return NoteListFragment()
        }
    }

    inner class NotesAdapter(
        private val notes: List<Note>
    ) :
        RecyclerView.Adapter<NotesViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_note, parent,false)
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
        RecyclerView.ViewHolder(itemView){
        fun bind(note: Note) {
            val binding = ItemNoteBinding.bind(itemView)
            binding.tvNoteItemTitle.text = note.title
            binding.ivNoteItemImportance.setBackgroundResource(
                getColorResource(note.importance))
        }
    }
}