package com.example.travelbucketlist.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    var radioOptions =
        mapOf("Light gray" to Color.LightGray, "White" to Color.White, "Cyan" to Color.Cyan)
        private set

    var backgroundColor by mutableStateOf(Color.LightGray)
        private set

    fun changeBackgroundColor(color: Color) {
        backgroundColor = color
    }
}