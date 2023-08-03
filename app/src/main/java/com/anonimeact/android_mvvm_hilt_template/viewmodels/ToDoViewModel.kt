package com.anonimeact.android_mvvm_hilt_template.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anonimeact.android_mvvm_hilt_template.db.entities.ToDoEntity
import com.anonimeact.simpletodolistapp.repositories.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repo: ToDoRepository
) : ViewModel() {

    fun getListToDo(page: Int, onFinish: ((List<ToDoEntity>) -> Unit)? = null) {
        viewModelScope.launch {
            val response = repo.getListToDo(page)
            onFinish?.invoke(response)
        }
    }

    fun addToDo(toDo: ToDoEntity) {
        viewModelScope.launch { repo.addToDo(toDo) }
    }

    fun addToDoMultiple(toDoList: List<ToDoEntity>, onFinish: ((Boolean) -> Unit)? = null) {
        viewModelScope.launch {
            repo.addToDoMultiple(toDoList)
            onFinish?.invoke(true)
        }
    }

    fun updateToDo(toDo: ToDoEntity) {
        viewModelScope.launch { repo.updateToDo(toDo) }
    }

    fun deleteToDo(toDo: ToDoEntity) {
        viewModelScope.launch { repo.deleteToDo(toDo) }
    }
}