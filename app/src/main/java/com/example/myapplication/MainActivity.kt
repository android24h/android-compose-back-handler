package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.utility.DoubleBackToExitHandler
import com.example.myapplication.utility.Example1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
         //   Example1()
            DoubleBackToExitHandler()
        }
    }
}


