package com.anonimeact.android_mvvm_hilt_template.db.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.anonimeact.android_mvvm_hilt_template.db.entities.ToDoEntity

@Dao
interface ToDoDao {
    @Query("SELECT * from todo_table limit 10 offset :page")
    suspend fun getAllToDo(page: Int): List<ToDoEntity>

    @Insert
    suspend fun addToDo(todo: ToDoEntity): Long

    @Insert
    suspend fun addToDoMultiple(todo: List<ToDoEntity>)

    @Update
    suspend fun updateToDo(todo: ToDoEntity)

    @Delete
    suspend fun deleteToDo(todo: ToDoEntity)
}