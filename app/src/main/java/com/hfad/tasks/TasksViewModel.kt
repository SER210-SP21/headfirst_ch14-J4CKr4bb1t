package com.hfad.tasks

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TasksViewModel (val dao: TaskDao) : ViewModel() {
    var newTaskName = ""


    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            Log.d("NEW TASK", newTaskName)
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
}