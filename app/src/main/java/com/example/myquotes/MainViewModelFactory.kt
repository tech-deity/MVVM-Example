package com.example.myquotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
//creating view model factory which will take Repository as parameter and return ViewModel

class MainViewModelFactory(private val quoteRepository: QuoteRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(quoteRepository) as T
    }
}