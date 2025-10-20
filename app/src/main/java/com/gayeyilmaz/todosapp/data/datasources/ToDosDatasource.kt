package com.gayeyilmaz.todosapp.data.datasources


import com.gayeyilmaz.todosapp.data.entity.ToDos
import com.gayeyilmaz.todosapp.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDatasource(var toDosDao: ToDosDao) {
    suspend fun save (name:String){
        toDosDao.save(ToDos(0,name))
    }

    suspend fun update (id : Int,name:String){
       toDosDao.update(id,name)
    }

    suspend fun delete(id:Int){
        toDosDao.delete(id)
    }

    suspend fun loadToDos():List<ToDos> = withContext(context = Dispatchers.IO){
        return@withContext toDosDao.loadToDao()



    }

    suspend fun search(searchText:String):List<ToDos> = withContext(context = Dispatchers.IO){
        return@withContext toDosDao.search(searchText)


    }
}