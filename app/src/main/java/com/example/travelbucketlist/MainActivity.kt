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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.travelbucketlist.ui.theme.TravelBucketListTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState", "UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TravelBucketListTheme {
                val bucketList = remember { mutableStateListOf<String>() }
                val selectedList = remember { mutableStateOf(setOf<String>()) }
                val navController = rememberNavController()

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
                                    route = Screen.ListScreen.route + "/{name}",
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
                    Navigation(navController = navController, bucketList, selectedList)
                }
            }
        }
    }
}
