package com.scan.hilt_roomdatabase.Repository

import com.scan.hilt_roomdatabase.DB.NoteDao
import com.scan.hilt_roomdatabase.DB.NoteModel
import javax.inject.Inject

class DbRepository @Inject constructor(private val dao: NoteDao) {

    fun saveNote(noteModel: NoteModel) = dao.insertNode(noteModel)
    fun updateNote(note: NoteModel) = dao.updateNote(note)
    fun deleteNote(note: NoteModel) = dao.deleteNote(note)
    fun getNote(id: Int): NoteModel = dao.getNote(id)
    fun getAllNotes() = dao.getAllNotes()


}