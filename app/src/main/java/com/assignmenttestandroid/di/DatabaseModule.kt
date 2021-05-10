package com.assignmenttestandroid.di

import android.content.Context
import androidx.room.Room
import com.assignmenttestandroid.db.ListDataBase
import com.assignmenttestandroid.util.Constant.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideListDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        ListDataBase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideListDataDao(db: ListDataBase) = db.getDataListDao()
}