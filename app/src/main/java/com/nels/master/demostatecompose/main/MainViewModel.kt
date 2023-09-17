package com.nels.master.demostatecompose.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var bookState by mutableStateOf(BookState())
        private set


    init {
        viewModelScope.launch {
            bookState = bookState.copy(
                loading = true
            )
            delay(5000)
            bookState = bookState.copy(
                libros = listOf(
                    Book("Libro", "Author"),
                    Book("Libro", "Author"),
                    Book("Libro", "Author"),
                    Book("Libro", "Author"),
                    Book("Libro", "Author"),
                    Book("Libro", "Author"),
                    Book("Libro", "Author"),
                    Book("Libro", "Author"),

                    ).mapIndexed { index, book ->
                    Book(book.title.plus(" $index"), book.author.plus(" $index"))
                }.toList(),
                loading = false
            )

        }
    }

}