package com.gayeyilmaz.todosapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gayeyilmaz.todosapp.data.entity.ToDos
import com.gayeyilmaz.todosapp.data.repos.ToDosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var toDosRepository = ToDosRepository()

    init{
        loadToDos()
    }
    //LiveData
    var toDosList = MutableLiveData<List<ToDos>>()
    fun delete(id:Int){
        CoroutineScope(context = Dispatchers.Main).launch {
            toDosRepository.delete(id)
            loadToDos()
        }

    }

    fun loadToDos() {
        CoroutineScope(context = Dispatchers.Main).launch {
            toDosList.value=toDosRepository.loadToDos()
        }
    }

    fun search(searchText:String){
        CoroutineScope(context = Dispatchers.Main).launch {
            toDosList.value=toDosRepository.search(searchText)
        }
    }
}