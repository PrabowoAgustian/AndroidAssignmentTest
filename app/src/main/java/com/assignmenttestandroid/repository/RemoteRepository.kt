package com.assignmenttestandroid.repository

import com.assignmenttestandroid.model.ListPhotos
import com.assignmenttestandroid.network.ApiService
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val apiService: ApiService
) : BaseRepository() {

    suspend fun getListPhotos(): List<ListPhotos>? {
        return safeApiCall(
            call = { apiService.getListPhotos() },
            error = "Error fetching news"
        )
    }
}