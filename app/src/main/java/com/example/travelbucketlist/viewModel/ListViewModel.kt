package com.example.travelbucketlist.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.travelbucketlist.model.ListItem

class ListViewModel : ViewModel() {

    var name: String by mutableStateOf("Unknown")
        private set

    var destination: String by mutableStateOf("")
        private set

    var selected: Boolean by mutableStateOf(false)

    var destinationList: MutableList<ListItem> = mutableStateListOf()

    fun addListItem() {
        destinationList.add(ListItem(destination, selected))
    }

    fun addName(nameInput: String) {
        name = nameInput
    }

    fun addDestination(destinationInput: String) {
        destination = destinationInput
    }

    fun changeSelected(listItem: ListItem) {
        if (destinationList.contains(listItem))
            destinationList[destinationList.indexOf(listItem)] = listItem
    }

    fun clearDestinationInput() {
        destination = ""
    }
}
