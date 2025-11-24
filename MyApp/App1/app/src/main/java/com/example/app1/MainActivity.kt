package com.example.app1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app1.ui.theme.App1Theme
import com.example.app1.ui.theme.GridScreen
import com.example.app1.ui.theme.InsertColumnsScreen
import com.example.app1.ui.theme.InsertRowsScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App1Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "insertRows") {
        composable("insertRows") {
            InsertRowsScreen(onNext = { rows ->
                navController.navigate("insertColumns/$rows")
            })
        }


        composable("insertColumns/{rows}") { backStack ->
            val rows = backStack.arguments?.getString("rows")?.toInt() ?: 1
            InsertColumnsScreen(rows = rows, onNext = { columns ->
                navController.navigate("grid/$rows/$columns")
            })
        }


        composable("grid/{rows}/{columns}") { backStack ->
            val rows = (backStack.arguments?.getString("rows") ?: "1").toInt()
            val columns = (backStack.arguments?.getString("columns") ?: "1").toInt()
            GridScreen(rows = rows, columns = columns)
        }
    }
}