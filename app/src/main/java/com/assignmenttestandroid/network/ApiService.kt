package com.assignmenttestandroid.network

import com.assignmenttestandroid.model.DataResponse
import com.assignmenttestandroid.model.ListPhotos
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getListPhotos(): Response<List<ListPhotos>>
}