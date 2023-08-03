package com.anonimeact.simpletodolistapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.anonimeact.android_mvvm_hilt_template.db.daos.ToDoDao
import com.anonimeact.android_mvvm_hilt_template.db.entities.ToDoEntity
import com.anonimeact.simpletodolistapp.utils.DateTypeConverter

@Database(entities = [ToDoEntity::class], version = 1, exportSchema = true)

@TypeConverters(DateTypeConverter::class)
abstract class ToDoListDb : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}