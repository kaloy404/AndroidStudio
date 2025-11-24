package com.myapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.myapp.ui.theme.GridItem

@Composable
fun GridScreen(rows: Int, columns: Int) {
    GridScreenContent(rows = rows, columns = columns)
}

@Composable
fun GridScreenContent(rows: Int, columns: Int) {
    Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
        Text(
            text = "Grid ($rows x $columns)",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        LazyColumn {
            items(rows) { rowIndex ->
                LazyRow {
                    items(columns) { columnIndex ->
                        GridItem(text = "Item [$rowIndex][$columnIndex]")
                    }
                }
            }
        }
    }
}
