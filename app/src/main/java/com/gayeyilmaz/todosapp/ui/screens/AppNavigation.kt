package com.gayeyilmaz.todosapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gayeyilmaz.todosapp.data.entity.ToDos
import com.gayeyilmaz.todosapp.ui.viewmodels.MainViewModel
import com.gayeyilmaz.todosapp.ui.viewmodels.SaveViewModel
import com.gayeyilmaz.todosapp.ui.viewmodels.UpdateViewModel
import com.google.gson.Gson
import kotlin.reflect.typeOf

@Composable
fun AppNavigation(
    mainViewModel: MainViewModel,
    saveViewModel: SaveViewModel,
    updateViewModel: UpdateViewModel
){
    val navController = rememberNavController();

    NavHost(navController=navController,startDestination= "mainScreen"){
        composable("mainScreen"){
            MainScreen(navController,mainViewModel = mainViewModel)
        }
        composable("saveScreen"){
            SaveScreen(saveViewModel = saveViewModel)
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
                UpdateScreen(toDo=toDo,updateViewModel= updateViewModel)
            }

        }


    }

}