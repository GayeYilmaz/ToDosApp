package com.gayeyilmaz.todosapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.gayeyilmaz.todosapp.data.repos.ToDosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SaveViewModel: ViewModel() {
    var toDosRepository = ToDosRepository()
     fun save (name:String){
         CoroutineScope(context = Dispatchers.Main).launch {
             toDosRepository.save(name)
         }

    }
}