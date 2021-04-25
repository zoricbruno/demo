package hr.mosaicapps.notesy.di

import hr.mosaicapps.notesy.data.database.NoteDao
import hr.mosaicapps.notesy.data.database.NotesDatabase
import hr.mosaicapps.notesy.data.database.NotesDatabaseBuilder
import hr.mosaicapps.notesy.data.repository.NoteRepository
import hr.mosaicapps.notesy.data.repository.NoteRepositoryImpl
import hr.mosaicapps.notesy.ui.newnote.viewmodels.NewNoteViewModel
import hr.mosaicapps.notesy.ui.noteslist.viewmodels.NoteListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single<NotesDatabase> { NotesDatabaseBuilder.getInstance() }
    single<NoteDao> { get<NotesDatabase>().noteDao() }
    single<NoteRepository> { NoteRepositoryImpl(get()) }
}

val viewModelModules = module {
    viewModel<NewNoteViewModel> { NewNoteViewModel(get()) }
    viewModel<NoteListViewModel> { NoteListViewModel(get()) }
}