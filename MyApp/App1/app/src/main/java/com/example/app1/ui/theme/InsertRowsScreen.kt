package com.example.app1.ui.theme

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.app1.ui.theme.*


@Composable
fun InsertRowsScreen(onNext: (Int) -> Unit) {
    var input by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        AppTitle("Insert Rows")
        AppTextField(value = input, onValueChange = { input = it })
        AppButton("Next") {
            val rows = input.toIntOrNull() ?: 1
            onNext(rows)
        }
    }
}
