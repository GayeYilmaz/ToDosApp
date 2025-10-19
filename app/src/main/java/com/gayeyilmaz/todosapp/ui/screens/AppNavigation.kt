package com.gayeyilmaz.todosapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gayeyilmaz.todosapp.data.entity.ToDos
import com.google.gson.Gson
import kotlin.reflect.typeOf

@Composable
fun AppNavigation(){
    val navController = rememberNavController();

    NavHost(navController=navController,startDestination= "mainScreen"){
        composable("mainScreen"){
            MainScreen(navController)
        }
        composable("saveScreen"){
            SaveScreen()
        }
        composable(
            "updateScreen/{toDo}",

            arguments = listOf(
                navArgument("toDo"){
                    type = NavType.StringType
                }
            )
        ){
            val jsonToDo = it.arguments?.getString("toDo")
            val toDo = Gson().fromJson(jsonToDo, ToDos::class.java)
            if(toDo != null){
                UpdateScreen(toDo=toDo)
            }

        }


    }

}