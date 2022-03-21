package com.example.myquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myquotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainviewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)


        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao() // so we have created dao here we have access database singleton and got the dao we cant access dao directly

        val repository = QuoteRepository(dao) // so we created repository here which requires Dao
                //here MainView Model Requires repository
        mainviewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainviewModel.getQuotes().observe(this,{
            binding.quotes = it.toString()
        })
        binding.btnAddQuote.setOnClickListener {
            val quote = Quote(0, "this is testing Vishal ","mc")
            mainviewModel.insertQuotes(quote)

        }
    }
}