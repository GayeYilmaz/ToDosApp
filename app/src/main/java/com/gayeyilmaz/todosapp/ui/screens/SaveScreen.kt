package com.gayeyilmaz.todosapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.gayeyilmaz.todosapp.R
import com.gayeyilmaz.todosapp.ui.components.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveScreen(){
    val toDoName = remember { mutableStateOf("") }

    fun save (name:String){
        Log.e("SaveScreen","$name")
    }
    Scaffold(

        topBar =  { CustomTopAppBar("Save Scren") },

    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(colorResource(R.color.background)).padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top

        ) {
            OutlinedTextField(
                value=toDoName.value,
                onValueChange = {toDoName.value = it},
                label={Text(text = "ToDo Name")},
                modifier = Modifier.fillMaxWidth().padding(top=50.dp),
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

            Button(
                onClick = {save(toDoName.value)},
                modifier = Modifier.fillMaxWidth(),
                enabled = toDoName.value.isNotBlank(),
                colors = ButtonDefaults.buttonColors(
                    colorResource(R.color.main_color),
                    contentColor = colorResource(R.color.white),
                    disabledContainerColor = colorResource(R.color.dark_gray),
                    disabledContentColor = colorResource(R.color.white),
                )
            ) {
                Text(text="Save")
            }



        }

    }

}