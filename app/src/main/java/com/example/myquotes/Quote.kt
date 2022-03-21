package com.example.myquotes

import androidx.room.Entity

@Entity(tableName="quote")
data class Quote(
    val id:Int,
    val text:String,
    val author:String
)
