package com.example.travelbucketlist

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.StartScreen.route) {
        composable(route = Screen.StartScreen.route) {
            StartScreen(navController = navController)
        }
        composable(
            route = Screen.MainScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Unknown"
                    nullable = true
                }
            )
        ) { entry ->
            MainScreen(name = entry.arguments?.getString("name"))
        }
    }
}
