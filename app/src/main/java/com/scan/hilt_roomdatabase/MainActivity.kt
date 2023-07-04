package com.scan.hilt_roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scan.hilt_roomdatabase.Adapter.NoteAdapter
import com.scan.hilt_roomdatabase.DB.NoteModel
import com.scan.hilt_roomdatabase.Repository.DbRepository
import com.scan.hilt_roomdatabase.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var repository: DbRepository

    @Inject
    lateinit var noteAdapter: NoteAdapter

    @Inject
    lateinit var note: NoteModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}