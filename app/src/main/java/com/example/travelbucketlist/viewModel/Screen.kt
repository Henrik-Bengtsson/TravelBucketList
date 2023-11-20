package com.example.travelbucketlist.viewModel

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home")
    object ListScreen : Screen("list")

    object SettingsScreen : Screen("settings")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
