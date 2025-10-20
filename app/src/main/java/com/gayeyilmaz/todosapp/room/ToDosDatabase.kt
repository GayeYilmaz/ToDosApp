package com.gayeyilmaz.todosapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gayeyilmaz.todosapp.data.entity.ToDos

@Database(entities = [ToDos::class],version=1)
abstract class ToDosDatabase: RoomDatabase() {

    abstract fun getToDosDao(): ToDosDao
}