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
fun InsertColumnsScreen(rows: Int, onNext: (Int) -> Unit) {
    val state = remember { InsertColumnsScreenState() }
    InsertColumnsScreenContent(state = state, onNext = onNext)
}

class InsertColumnsScreenState {
    var columns by mutableStateOf("")
}

@Composable
fun InsertColumnsScreenContent(state: InsertColumnsScreenState, onNext: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AppTitle("Enter Number of Columns")
        AppTextField(
            value = state.columns,
            onValueChange = { state.columns = it }
        )
        AppButton(text = "Next") {
            if (state.columns.isNotEmpty()) onNext(state.columns.toInt())
        }
    }
}
