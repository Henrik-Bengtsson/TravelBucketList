package com.example.travelbucketlist

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.travelbucketlist.model.BottomNavItem
import com.example.travelbucketlist.viewModel.BottomNavigationBar
import com.example.travelbucketlist.viewModel.ListViewModel
import com.example.travelbucketlist.viewModel.Navigation
import com.example.travelbucketlist.viewModel.Screen
import com.example.travelbucketlist.viewModel.SettingsViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val settingsViewModel = viewModel<SettingsViewModel>()
            val listViewModel = viewModel<ListViewModel>()

            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        items = listOf(
                            BottomNavItem(
                                name = "Home",
                                route = Screen.HomeScreen.route,
                                icon = Icons.Default.Home
                            ),
                            BottomNavItem(
                                name = "List",
                                route = Screen.ListScreen.route + "/" + listViewModel.name,
                                icon = Icons.Default.List
                            ),
                            BottomNavItem(
                                name = "Settings",
                                route = Screen.SettingsScreen.route,
                                icon = Icons.Default.Settings
                            )
                        ),
                        navController = navController,
                        onItemClick = {
                            navController.navigate(it.route)
                        }
                    )
                }
            ) {
                Navigation(navController = navController, settingsViewModel, listViewModel)
            }

        }
    }
}
