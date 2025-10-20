package com.gayeyilmaz.todosapp.data.repos


import com.gayeyilmaz.todosapp.data.datasources.ToDosDatasource
import com.gayeyilmaz.todosapp.data.entity.ToDos

class ToDosRepository (var toDosDatasource: ToDosDatasource){


    suspend fun save (name:String){
        toDosDatasource.save(name)
    }

    suspend fun update (id : Int,name:String){
        toDosDatasource.update(id,name)
    }

    suspend fun delete(id:Int){
       toDosDatasource.delete(id)
    }

    suspend fun loadToDos():List<ToDos> {
       return  toDosDatasource.loadToDos()
    }

    suspend fun search(searchText:String):List<ToDos>{
        return toDosDatasource.search(searchText)
    }
}