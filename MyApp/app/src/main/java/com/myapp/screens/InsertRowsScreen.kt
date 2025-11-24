package com.myapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapp.ui.theme.AppButton
import com.myapp.ui.theme.AppTextField
import com.myapp.ui.theme.AppTitle

@Composable
fun InsertRowsScreen(onNext: (Int) -> Unit) {
    val state = remember { InsertRowsScreenState() }
    InsertRowsScreenContent(state = state, onNext = onNext)
}

class InsertRowsScreenState {
    var rows by mutableStateOf("")
}

@Composable
fun InsertRowsScreenContent(state: InsertRowsScreenState, onNext: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AppTitle("Enter Number of Rows")
        AppTextField(
            value = state.rows,
            onValueChange = { state.rows = it }
        )
        AppButton(text = "Next") {
            if (state.rows.isNotEmpty()) onNext(state.rows.toInt())
        }
    }
}
