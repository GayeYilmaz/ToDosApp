package com.gayeyilmaz.todosapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gayeyilmaz.todosapp.data.entity.ToDos

@Dao //Database Access Object
interface ToDosDao {

    @Query(value="SELECT * FROM toDos")
    suspend fun loadToDao(): List<ToDos>

    @Insert
    suspend fun save(toDos:ToDos)

    @Query(value="UPDATE toDos SET name = :name WHERE id = :id")
    suspend fun update(id:Int,name:String)

    @Query(value="DELETE FROM toDos  WHERE id = :id")
    suspend fun delete(id:Int)

    @Query(value="SELECT * FROM toDos WHERE name LIKE '%' || :searchText || '%'")
    suspend fun search(searchText:String): List<ToDos>

}