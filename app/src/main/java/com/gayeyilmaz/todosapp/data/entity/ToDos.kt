package com.gayeyilmaz.todosapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDos")
data class ToDos(@PrimaryKey(autoGenerate = true)@ColumnInfo(name="id") val id:Int,
                 @ColumnInfo(name="name")val name:String) {
}