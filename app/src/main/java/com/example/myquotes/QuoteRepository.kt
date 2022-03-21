package com.example.myquotes

import androidx.lifecycle.LiveData


//Repository talks with Database using DAO

class QuoteRepository(private val quoteDao: QuoteDao) {
    fun getQuotes(): LiveData<List<Quote>> {
        return quoteDao.getQuotes()
    }

    suspend fun insertQuotes(quote: Quote) {
        quoteDao.insertQuote(quote)
    }
}