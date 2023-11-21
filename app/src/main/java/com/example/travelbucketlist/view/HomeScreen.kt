package com.example.travelbucketlist.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelbucketlist.viewModel.ListViewModel
import com.example.travelbucketlist.viewModel.Screen
import com.example.travelbucketlist.viewModel.SettingsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    settingsViewModel: SettingsViewModel,
    listViewModel: ListViewModel
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(settingsViewModel.backgroundColor)
    ) {
        Text(
            text = "Welcome",
            fontSize = 36.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier.padding(vertical = 25.dp)
        )
        OutlinedTextField(
            value = listViewModel.name,
            label = { Text("Enter your name", fontSize = 24.sp) },
            onValueChange = {
                listViewModel.addName(it)
            },
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color.White)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate(Screen.ListScreen.withArgs(listViewModel.name))
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 50.dp)
        ) {
            Text(text = "To your bucket list")
        }
    }
}
