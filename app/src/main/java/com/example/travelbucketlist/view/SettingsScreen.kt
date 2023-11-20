package com.example.travelbucketlist.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelbucketlist.viewModel.SettingsViewModel

@Composable
fun SettingsScreen(viewModel: SettingsViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(viewModel.backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "Select color",
                fontSize = 20.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.padding(horizontal = 15.dp)
            )
            RadioButtonBox(viewModel)
        }
    }
}

@Composable
fun RadioButtonBox(viewModel: SettingsViewModel) {

    Column {
        viewModel.radioOptions.forEach { color ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (color.value == viewModel.backgroundColor),
                        onClick = {
                            viewModel.backgroundColor
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (color.value == viewModel.backgroundColor),
                    onClick = {
                        viewModel.changeBackgroundColor(color.value)
                    }
                )
                Text(
                    text = color.key,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(vertical = 14.dp)
                )
            }
        }
    }
}
