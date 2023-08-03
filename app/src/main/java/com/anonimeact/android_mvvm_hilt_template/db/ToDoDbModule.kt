package com.anonimeact.simpletodolistapp.db

import android.content.Context
import androidx.room.Room
import com.anonimeact.android_mvvm_hilt_template.db.daos.ToDoDao
import com.anonimeact.simpletodolistapp.repositories.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ToDoDbModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): ToDoListDb = Room.databaseBuilder(
        appContext.applicationContext,
        ToDoListDb::class.java,
        "simple_todo.db"
    ).build()

    @Provides
    fun provideToDoDao(db: ToDoListDb): ToDoDao = db.toDoDao()

    @Provides
    fun provideToDoRepo(dao: ToDoDao): ToDoRepository = ToDoRepository(dao)
}
