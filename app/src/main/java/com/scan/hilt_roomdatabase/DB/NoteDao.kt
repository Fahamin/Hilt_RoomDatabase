package com.scan.hilt_roomdatabase.DB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.scan.hilt_roomdatabase.Uitls.Constants.NOTE_TABLE


@Dao
interface NoteDao  {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNode(noteModel: NoteModel)

    @Update
    fun updateNote(noteEntity: NoteModel)

    @Delete
    fun deleteNote(noteEntity: NoteModel)

    @Query("SELECT * FROM $NOTE_TABLE ORDER BY id DESC")
    fun getAllNotes() : MutableList<NoteModel>

    @Query("SELECT * FROM $NOTE_TABLE WHERE id LIKE :id")
    fun getNote(id : Int) : NoteModel
}