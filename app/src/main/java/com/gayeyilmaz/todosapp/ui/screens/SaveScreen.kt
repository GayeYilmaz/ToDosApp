package com.gayeyilmaz.todosapp.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api


import androidx.compose.material3.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.gayeyilmaz.todosapp.R
import com.gayeyilmaz.todosapp.ui.components.CustomButton
import com.gayeyilmaz.todosapp.ui.components.CustomTextField
import com.gayeyilmaz.todosapp.ui.components.CustomTopAppBar
import com.gayeyilmaz.todosapp.ui.viewmodels.SaveViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveScreen(saveViewModel: SaveViewModel){
    val toDoName = remember { mutableStateOf("") }


    Scaffold(

        topBar =  { CustomTopAppBar("Save Scren") },

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(colorResource(R.color.background))
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {


            CustomTextField(
                hint="ToDo Name",
                value= toDoName.value ,
                onValueChange = {toDoName.value = it}
            )

            CustomButton(
                buttonText="Save",
                enable = toDoName.value.isNotBlank(),
                onButtonClicked = {saveViewModel.save(toDoName.value)})



        }

    }

}