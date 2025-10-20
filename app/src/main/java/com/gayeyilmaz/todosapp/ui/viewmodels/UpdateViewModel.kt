package com.gayeyilmaz.todosapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.gayeyilmaz.todosapp.data.repos.ToDosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateViewModel: ViewModel() {
    var toDosRepository = ToDosRepository()

    fun update (id : Int,name:String){
        CoroutineScope(context = Dispatchers.Main).launch {
            toDosRepository.update(id,name)
        }

    }
}