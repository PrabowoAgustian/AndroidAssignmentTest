package com.assignmenttestandroid.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignmenttestandroid.model.ListPhotos
import com.assignmenttestandroid.repository.LocalRepository
import com.assignmenttestandroid.repository.RemoteRepository
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository
) : ViewModel() {

    val listPhotosLiveData = MutableLiveData<MutableList<ListPhotos>>()

    var keyWord: String = ""

    init {
        getListPhotos(keyWord)
    }

    fun getListPhotos(key: String) = viewModelScope.launch {
        val listPhotos = remoteRepository.getListPhotos()
        keyWord = key
        listPhotosLiveData.postValue(listPhotos as MutableList<ListPhotos>)
        saveListPhotos(listPhotos)
    }

    private fun saveListPhotos(listPhotos: MutableList<ListPhotos>) = viewModelScope.launch {
        localRepository.insertListPhotosToDb(listPhotos)
    }
}