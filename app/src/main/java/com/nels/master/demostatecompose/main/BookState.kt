package com.nels.master.demostatecompose.main

data class BookState(
    val libros:List<Book> = emptyList(),
    val loading:Boolean = false
)