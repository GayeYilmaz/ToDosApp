package com.gayeyilmaz.todosapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.gayeyilmaz.todosapp.R
import com.gayeyilmaz.todosapp.data.entity.ToDos


@Composable
fun ToDoItem(toDo: ToDos, onItemClick:()->Unit, onDeleteClick:(Int)->Unit){

    Card(
        modifier = Modifier.padding(vertical=4.dp)
            .clickable{ onItemClick() },
        colors= CardDefaults.cardColors(
            containerColor = colorResource(R.color.white)
        )
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = toDo.name, modifier = Modifier.padding(start=16.dp))
            IconButton(onClick = {onDeleteClick(toDo.id)})
            {
                Icon(Icons.Filled.Close, contentDescription = "Delete Icon", tint = colorResource(R.color.dark_gray))
            }

        }

    }

}

