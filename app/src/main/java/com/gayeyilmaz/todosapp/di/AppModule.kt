package com.gayeyilmaz.todosapp.di

import android.content.Context
import androidx.room.Room
import com.gayeyilmaz.todosapp.data.datasources.ToDosDatasource
import com.gayeyilmaz.todosapp.data.repos.ToDosRepository
import com.gayeyilmaz.todosapp.room.ToDosDao
import com.gayeyilmaz.todosapp.room.ToDosDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDosRepository(toDosDatasource: ToDosDatasource): ToDosRepository{
        return ToDosRepository(toDosDatasource)
    }

    @Provides
    @Singleton
    fun provideToDosDataSource(toDosDao: ToDosDao): ToDosDatasource{
        return ToDosDatasource(toDosDao)
    }

    @Provides
    @Singleton
    fun provideToDosDao(@ApplicationContext context: Context):ToDosDao{
        val db = Room.databaseBuilder(context, ToDosDatabase::class.java,"todos_app.sqlite")
            .createFromAsset("todos_app.sqlite")
            .build()

        return db.getToDosDao()
    }
}