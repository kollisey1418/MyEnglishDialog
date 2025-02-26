package com.example.myenglishdialog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.myenglishdialog.ui.theme.MyEnglishDialogTheme
import com.example.myenglishdialog.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyEnglishDialogTheme {
                val navController = rememberNavController() // ВНУТРИ setContent
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavHost(navController)               // Тоже внутри
                }
            }
        }
    }
}



