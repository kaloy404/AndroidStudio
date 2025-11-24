package com.example.app1.ui.theme

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.example.app1.ui.theme.*


@Composable
fun InsertColumnsScreen(rows: Int, onNext: (Int) -> Unit) {
    var input by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        AppTitle("Insert Columns")
        AppTextField(value = input, onValueChange = { input = it })
        AppButton("Next") {
            val cols = input.toIntOrNull() ?: 1
            onNext(cols)
        }
    }
}