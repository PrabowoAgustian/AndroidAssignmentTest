package com.assignmenttestandroid.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assignmenttestandroid.model.ListPhotos

@Database(
    entities = [ListPhotos::class],
    version = 1
)
abstract class ListDataBase: RoomDatabase() {
    abstract fun getDataListDao(): DataListDao
}