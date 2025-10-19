package com.gayeyilmaz.todosapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.gayeyilmaz.todosapp.R

@Composable
fun CustomTextField(hint:String,value:String,onValueChange:(String)->Unit){
    OutlinedTextField(
        value=value,
        onValueChange = onValueChange,
        label={Text(text = hint)},
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

}