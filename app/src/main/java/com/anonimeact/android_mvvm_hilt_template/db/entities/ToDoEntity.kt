package com.anonimeact.android_mvvm_hilt_template.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "todo_table")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var toDoTitle: String,
    var toDoDescription: String,
    var toDoDueDate: Date
)