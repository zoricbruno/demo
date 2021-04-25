package hr.mosaicapps.notesy.ui.noteslist.fragments

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hr.mosaicapps.notesy.ui.noteslist.NotesAdapter
import hr.mosaicapps.notesy.databinding.FragmentNoteListBinding
import hr.mosaicapps.notesy.ui.noteslist.OnNoteSelectedListener
import hr.mosaicapps.notesy.ui.noteslist.viewmodels.NoteListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.dsl.koinApplication

class NoteListFragment : Fragment() {

    private lateinit var onNoteSelectedListener: OnNoteSelectedListener
    private lateinit var binding: FragmentNoteListBinding
    private lateinit var notesAdapter: NotesAdapter
    private val viewModel by viewModel<NoteListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnNoteSelectedListener) {
            onNoteSelectedListener = context
        }
    }

    private fun setupRecyclerView() {
        notesAdapter = NotesAdapter(listOf(), onNoteSelectedListener)
        binding.apply {
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rvNotes.layoutManager = layoutManager
            rvNotes.adapter = notesAdapter
            rvNotes.addItemDecoration(DividerItemDecoration(rvNotes.context, layoutManager.orientation))
        }
        viewModel.notes.observe(viewLifecycleOwner) { notesAdapter.refreshData(it) }
    }

    companion object {
        const val TAG = "Notes list"
        fun create(): NoteListFragment {
            return NoteListFragment()
        }
    }
}


