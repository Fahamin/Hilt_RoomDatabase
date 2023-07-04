package com.scan.hilt_roomdatabase.DB

import androidx.room.RoomDatabase


abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}