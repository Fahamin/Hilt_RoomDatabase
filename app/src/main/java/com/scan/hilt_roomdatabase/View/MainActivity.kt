package com.scan.hilt_roomdatabase.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.scan.hilt_roomdatabase.Adapter.NoteAdapter
import com.scan.hilt_roomdatabase.DB.NoteModel
import com.scan.hilt_roomdatabase.R
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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddNote.setOnClickListener {
            startActivity(Intent(this,AddNoteActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        checkItem()
    }

    private fun checkItem() {
       binding.apply {
           if(repository.getAllNotes().isNotEmpty())
           {
               rvNoteList.visibility = View.VISIBLE
               tvEmptyText.visibility = View.GONE
               noteAdapter.differ.submitList(repository.getAllNotes())
               setupRecyclerView()
           }else{
               rvNoteList.visibility=View.GONE
               tvEmptyText.visibility=View.VISIBLE
           }
       }
    }

    private fun setupRecyclerView(){
        binding.rvNoteList.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=noteAdapter
        }

    }
}