package com.gayeyilmaz.todosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.gayeyilmaz.todosapp.ui.screens.AppNavigation
import com.gayeyilmaz.todosapp.ui.theme.ToDosAppTheme
import com.gayeyilmaz.todosapp.ui.viewmodels.MainViewModel
import com.gayeyilmaz.todosapp.ui.viewmodels.SaveViewModel
import com.gayeyilmaz.todosapp.ui.viewmodels.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel : MainViewModel by viewModels()
    val saveViewModel : SaveViewModel by viewModels()
    val updateViewModel : UpdateViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDosAppTheme {
                AppNavigation(
                    mainViewModel = mainViewModel,
                    saveViewModel = saveViewModel,
                    updateViewModel = updateViewModel
                )

            }
        }
    }
}

