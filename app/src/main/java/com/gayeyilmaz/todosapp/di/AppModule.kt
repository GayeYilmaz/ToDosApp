package com.gayeyilmaz.todosapp.di

import com.gayeyilmaz.todosapp.data.datasources.ToDosDatasource
import com.gayeyilmaz.todosapp.data.repos.ToDosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideToDosDataSource(): ToDosDatasource{
        return ToDosDatasource()
    }
}