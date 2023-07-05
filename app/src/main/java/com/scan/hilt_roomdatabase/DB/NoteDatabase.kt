package com.scan.hilt_roomdatabase.DB

import android.os.Build.VERSION_CODES.N
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

}