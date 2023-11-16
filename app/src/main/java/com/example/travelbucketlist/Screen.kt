package com.example.travelbucketlist

sealed class Screen(val route: String) {
    object StartScreen : Screen("start_screen")
    object MainScreen : Screen("main_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
