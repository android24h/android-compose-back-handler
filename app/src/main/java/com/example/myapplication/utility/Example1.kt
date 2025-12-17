package com.example.myapplication.utility

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun Example1() {
    val context= LocalContext.current
    var onBackPress by remember {
        mutableStateOf(0L)
    }

    BackHandler {
        var now=System.currentTimeMillis()
        if (now-onBackPress<2000){
            (context as Activity).finish()
        }else{
            Toast.makeText(context,"Press another key",Toast.LENGTH_SHORT).show()
        }

        onBackPress=now

    }

}