package com.assignmenttestandroid.repository

import com.assignmenttestandroid.db.DataListDao
import com.assignmenttestandroid.model.ListPhotos
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val db: DataListDao
) : BaseRepository() {

    suspend fun insertListPhotosToDb(listPhotos: MutableList<ListPhotos>) = db.insertData(listPhotos)

    suspend fun deleteListPhotos(listPhotos: ListPhotos) = db.deleteData(listPhotos)

    fun getSavedListPhotos() = db.getSavedData()
}