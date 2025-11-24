package com.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.myapp.screens.GridScreen
import com.myapp.screens.InsertColumnsScreen
import com.myapp.screens.InsertRowsScreen
import com.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "rows") {
        composable("rows") {
            InsertRowsScreen(onNext = { rows ->
                navController.navigate("columns/$rows")
            })
        }
        composable(
            route = "columns/{rows}",
            arguments = listOf(navArgument("rows") { type = NavType.IntType })
        ) { backStackEntry ->
            val rows = backStackEntry.arguments!!.getInt("rows")
            InsertColumnsScreen(rows = rows, onNext = { columns ->
                navController.navigate("grid/$rows/$columns")
            })
        }
        composable(
            route = "grid/{rows}/{columns}",
            arguments = listOf(
                navArgument("rows") { type = NavType.IntType },
                navArgument("columns") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val rows = backStackEntry.arguments!!.getInt("rows")
            val columns = backStackEntry.arguments!!.getInt("columns")
            GridScreen(rows = rows, columns = columns)
        }
    }
}
