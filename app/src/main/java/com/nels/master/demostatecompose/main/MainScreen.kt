package com.nels.master.demostatecompose.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(viewModel: MainViewModel) {

    Box(modifier = Modifier.fillMaxSize()) {

        if (viewModel.bookState.loading) {
            LoadingElement()
        } else {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(viewModel.bookState.libros) {
                    Element(book = it)
                }
            }
        }
    }
}

@Composable
fun Element(book: Book) {
    Column {
        Text(text = book.title)
        Text(text = book.author)
        Divider(color = Color.Gray)
    }
}

@Composable
fun LoadingElement() {

    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.error,
        )
    }
}