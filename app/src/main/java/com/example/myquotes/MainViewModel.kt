package com.example.myquotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


//since this view model class take quotesRepository as ParaMeter we have to create View model Factory
class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes(): LiveData<List<Quote>> {
        return quoteRepository.getQuotes()
    }

    fun insertQuotes(quote: Quote) {

        //since this is input operation which takes place in background thread thats why we are using here
        //viewmodel scope since its in view model and DISPATCHERS.IO
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuotes(quote)

        }
    }
}