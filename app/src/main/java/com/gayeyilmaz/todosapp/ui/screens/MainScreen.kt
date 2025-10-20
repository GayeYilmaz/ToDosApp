package com.gayeyilmaz.todosapp.ui.screens


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gayeyilmaz.todosapp.R
import com.gayeyilmaz.todosapp.data.entity.ToDos
import com.gayeyilmaz.todosapp.ui.components.CustomTopAppBar
import com.gayeyilmaz.todosapp.ui.components.ToDoItem
import com.gayeyilmaz.todosapp.ui.viewmodels.MainViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController,mainViewModel: MainViewModel){
    val searchQuery = remember { mutableStateOf("") }

    fun search(searchText:String){
        Log.e("MainScreen","Search: $searchText")
    }
    fun loadToDos():List<ToDos>{
        return listOf(
            ToDos(1,"work"),
            ToDos(2,"study cse"),
            ToDos(3,"study jetpack compose")


        )
    }
    fun delete(id:Int){
        Log.e("MainScreen","Delete: $id")
    }

    val toDosList = remember{mutableStateOf(loadToDos())}
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

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
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(

            modifier = Modifier.fillMaxSize().padding(paddingValues).background(colorResource(R.color.background)).padding(16.dp),


        ) {
            OutlinedTextField(
                value=searchQuery.value,
                onValueChange = {searchQuery.value = it
                    search(it)


                                },
                label={Text(text = stringResource(R.string.search_hint_text))},
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Seacrh Field", tint = colorResource(R.color.main_color))},
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = colorResource(R.color.white),
                    unfocusedContainerColor = colorResource(R.color.white),
                    disabledContainerColor  = colorResource(R.color.white),
                    focusedLabelColor  = colorResource(R.color.main_color),
                    cursorColor  = colorResource(R.color.main_color),
                    focusedBorderColor = colorResource(R.color.main_color),
                    unfocusedBorderColor = colorResource(R.color.white),

                    )
            )
            Spacer(modifier = Modifier.padding(bottom = 16.dp))

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(count=toDosList.value.size,
                    itemContent = {
                        val toDo = toDosList.value[it]

                        ToDoItem(
                            toDo = toDo,
                            onItemClick = {
                                val toDoJson = Gson().toJson(toDo)
                                navController.navigate("updateScreen/$toDoJson")
                            },
                            onDeleteClick = {
                                scope.launch {
                                    val sb = snackbarHostState.showSnackbar(
                                        message =context.getString(R.string.snackbar_delete_message,toDo.name),
                                        actionLabel = context.getString(R.string.snackbar_delete_action_text)
                                    )
                                    if(sb == SnackbarResult.ActionPerformed){
                                        delete(it)
                                    }
                                }

                            }
                        )



                    }
                    )
            }

        }

    }

}