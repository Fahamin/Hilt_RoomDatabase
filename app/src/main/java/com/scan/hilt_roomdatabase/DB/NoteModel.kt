package com.scan.hilt_roomdatabase.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.scan.hilt_roomdatabase.Uitls.Constants.NOTE_TABLE


@Entity(tableName = NOTE_TABLE)
data class NoteModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "title")
    val title: String = "",

    @ColumnInfo(name = "des")
    val des: String = ""
)
