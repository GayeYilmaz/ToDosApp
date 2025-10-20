package com.gayeyilmaz.todosapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.gayeyilmaz.todosapp.data.repos.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(var toDosRepository:ToDosRepository): ViewModel() {


    fun update (id : Int,name:String){
        CoroutineScope(context = Dispatchers.Main).launch {
            toDosRepository.update(id,name)
        }

    }
}