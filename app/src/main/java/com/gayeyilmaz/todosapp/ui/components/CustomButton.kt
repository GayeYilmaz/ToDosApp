package com.gayeyilmaz.todosapp.ui.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.gayeyilmaz.todosapp.R

@Composable
fun CustomButton(buttonText:String,enable:Boolean,onButtonClicked:()->Unit){
    Button(
        onClick = onButtonClicked,
        modifier = Modifier.fillMaxWidth(),
        enabled = enable,
        colors = ButtonDefaults.buttonColors(
            colorResource(R.color.main_color),
            contentColor = colorResource(R.color.white),
            disabledContainerColor = colorResource(R.color.dark_gray),
            disabledContentColor = colorResource(R.color.white),
        )
    ) {
        Text(text=buttonText)
    }

}