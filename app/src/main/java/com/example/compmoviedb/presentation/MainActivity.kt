package com.example.compmoviedb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.compmoviedb.presentation.navigation.SetupNavHost
import com.example.compmoviedb.presentation.ui.theme.CompmoviedbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompmoviedbTheme {
                val navController = rememberNavController()
                SetupNavHost(navController = navController)
            }
        }
    }
}