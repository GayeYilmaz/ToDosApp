package com.gayeyilmaz.todosapp.data.datasources

import android.util.Log
import com.gayeyilmaz.todosapp.data.entity.ToDos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDatasource {
    suspend fun save (name:String){
        Log.e("ToDosDatasource","$name")
    }

    suspend fun update (id : Int,name:String){
        Log.e("ToDosDatasource","$id - $name")
    }

    suspend fun delete(id:Int){
        Log.e("ToDosDatasource","Delete: $id")
    }

    suspend fun loadToDos():List<ToDos> = withContext(context = Dispatchers.IO){
        return@withContext listOf(
            ToDos(1,"work"),
            ToDos(2,"study cse"),
            ToDos(3,"study jetpack compose")


        )
    }

    suspend fun search(searchText:String):List<ToDos> = withContext(context = Dispatchers.IO){
        return@withContext listOf(
            ToDos(1,"work"),

        )
    }
}