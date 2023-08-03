package com.anonimeact.simpletodolistapp.repositories

import com.anonimeact.android_mvvm_hilt_template.db.daos.ToDoDao
import com.anonimeact.android_mvvm_hilt_template.db.entities.ToDoEntity
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val dao: ToDoDao) {
    suspend fun getListToDo(page: Int): List<ToDoEntity> {
        return dao.getAllToDo(page)
    }

    suspend fun addToDo(toDo: ToDoEntity): Long {
        return dao.addToDo(toDo)
    }

    suspend fun addToDoMultiple(toDoList: List<ToDoEntity>) {
        return dao.addToDoMultiple(toDoList)
    }

    suspend fun updateToDo(toDo: ToDoEntity) {
        dao.updateToDo(toDo)
    }

    suspend fun deleteToDo(toDo: ToDoEntity) {
        dao.deleteToDo(toDo)
    }

}