package com.example.travelbucketlist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelbucketlist.R
import com.example.travelbucketlist.viewModel.ListViewModel
import com.example.travelbucketlist.viewModel.SettingsViewModel

@Composable
fun ListScreen(
    settingsViewModel: SettingsViewModel,
    listViewModel: ListViewModel
) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(settingsViewModel.backgroundColor)
    ) {
        ImageCard(
            painter = painterResource(id = R.drawable.maldives),
            contentDescription = "My travel bucket list",
            title = "My travel bucket list",
            modifier = Modifier.padding(15.dp)
        )
        InputBox(listViewModel)
        TextBox(listViewModel)
        ListBox(listViewModel)
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 30.sp))
            }
        }
    }
}

@Composable
fun TextBox(listViewModel: ListViewModel) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {
        Text(
            text = "${listViewModel.name}'s bucket list",
            fontSize = 28.sp,
            textDecoration = TextDecoration.Underline,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputBox(viewModel: ListViewModel) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        OutlinedTextField(
            value = viewModel.destination,
            label = {
                Text("Enter destination")
            },
            onValueChange = {
                viewModel.addDestination(it)
            },
            singleLine = true,
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .background(Color.White)
                .height(60.dp)

        )
        Spacer(modifier = Modifier.width(10.dp))
        Button(onClick = {
            viewModel.addListItem()
            viewModel.clearDestinationInput()
        }) {
            Text("Add", fontSize = 18.sp)
        }
    }
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun ListBox(viewModel: ListViewModel) {

    LazyColumn {
        itemsIndexed(viewModel.destinationList) { _, listItem ->
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp)
            ) {
                Checkbox(
                    checked = listItem.selected,
                    onCheckedChange = {
                        listItem.selected = it
                        viewModel.changeSelected(listItem)
                        println(viewModel.destinationList.toList())
                    },
                    colors = CheckboxDefaults.colors(Color.Green)
                )
                Text(
                    text = listItem.destination,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                )
            }
        }
    }
}
