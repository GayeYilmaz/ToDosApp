package com.gayeyilmaz.todosapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.gayeyilmaz.todosapp.data.repos.ToDosRepository

class MainViewModel : ViewModel() {
    var toDosRepository = ToDosRepository()
}