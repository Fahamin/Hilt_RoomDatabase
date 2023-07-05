package com.scan.hilt_roomdatabase.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.scan.hilt_roomdatabase.Adapter.NoteAdapter
import com.scan.hilt_roomdatabase.DB.NoteModel
import com.scan.hilt_roomdatabase.R
import com.scan.hilt_roomdatabase.Repository.DbRepository
import com.scan.hilt_roomdatabase.Uitls.Constants.BUNDLE_NOTE_ID
import com.scan.hilt_roomdatabase.databinding.ActivityUpdateNoteBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UpdateNoteActivity : AppCompatActivity() {


    private lateinit var binding: ActivityUpdateNoteBinding

    @Inject
    lateinit var repository: DbRepository

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var note: NoteModel

    private var noteId = 0
    private var defaultTitle = ""
    private var defaultDesc = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
            noteId = it.getInt(BUNDLE_NOTE_ID)
        }

        binding.apply {
            defaultTitle = repository.getNote(noteId).title
            defaultDesc = repository.getNote(noteId).des

            edtTitle.setText(defaultTitle)
            edtDesc.setText(defaultDesc)

            btnDelete.setOnClickListener {
                note = NoteModel(noteId, defaultTitle, defaultDesc)
                repository.deleteNote(note)
                finish()
            }

            btnSave.setOnClickListener {
                val title = edtTitle.text.toString()
                val desc = edtDesc.text.toString()
                if (title.isNotEmpty() || desc.isNotEmpty()) {
                    note = NoteModel(noteId, title, desc)
                    repository.updateNote(note)
                    finish()
                } else {
                    Snackbar.make(it, "Title and Description cannot be Empty", Snackbar.LENGTH_LONG)
                        .show()
                }
            }
        }

    }
}