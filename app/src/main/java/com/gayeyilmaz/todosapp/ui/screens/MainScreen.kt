package com.gayeyilmaz.todosapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.gayeyilmaz.todosapp.R
import com.gayeyilmaz.todosapp.data.entity.ToDos
import com.gayeyilmaz.todosapp.ui.components.CustomTopAppBar
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){
    Scaffold(

        topBar = {
            CustomTopAppBar("ToDos")
        }
        ,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("saveScreen")

                },
                containerColor = colorResource(R.color.main_color),
                content = {
                    Icon(Icons.Filled.Add, contentDescription = "Go to Save Screen", tint = colorResource(R.color.white))
                }
            )
        }

    ) { paddingValues ->
        Column(

            modifier = Modifier.fillMaxSize().padding(paddingValues).background(colorResource(R.color.background)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly

        ) {
            Button(onClick = {

                val toDo = ToDos(1,"work")
                val toDoJson = Gson().toJson(toDo)
                navController.navigate("updateScreen/$toDoJson")
            },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.main_color))

            ) {Text(text = "To Update Screen") }
        }

    }

}