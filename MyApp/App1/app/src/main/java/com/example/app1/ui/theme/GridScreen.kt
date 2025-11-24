package com.example.app1.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.app1.ui.theme.GridItem


@Composable
fun GridScreen(rows: Int, columns: Int) {
    Column(modifier = Modifier.fillMaxSize()) {
        AppTitle("Grid: $rows x $columns")

        LazyColumn {
            items(rows) { rowIndex ->
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(columns) { colIndex ->
                        GridItem(text = "Item [${rowIndex+1}][${colIndex+1}]")
                    }
                }
            }
        }
    }
}