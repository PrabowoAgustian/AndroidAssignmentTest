package com.assignmenttestandroid.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.assignmenttestandroid.model.ListPhotos

@Dao
interface DataListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(listPhotos: MutableList<ListPhotos>)

    @Query("SELECT * FROM dataListPhotos")
    fun getSavedData(): LiveData<MutableList<ListPhotos>>

    @Delete
    suspend fun deleteData(listPhotos: ListPhotos)
}