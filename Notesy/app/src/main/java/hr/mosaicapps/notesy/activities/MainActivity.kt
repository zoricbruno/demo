package hr.mosaicapps.notesy.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.mosaicapps.notesy.R
import hr.mosaicapps.notesy.fragments.NoteDetailsFragment
import hr.mosaicapps.notesy.fragments.NoteListFragment
import hr.mosaicapps.notesy.model.Note

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.fl_fragmentContainer, NoteListFragment.create(), "List")
                .commit()
        }
    }
}