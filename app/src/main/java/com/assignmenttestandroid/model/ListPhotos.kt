package com.assignmenttestandroid.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dataListPhotos")
data class ListPhotos (
    @PrimaryKey
    var albumId: Int,
    var id: Int,
    var title: String,
    var url: String,
    var thumbnailUrl: String
)