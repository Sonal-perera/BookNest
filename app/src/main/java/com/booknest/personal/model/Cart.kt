package com.booknest.community.model

data class Cart (
    val id:String,
    val name: String,
    val author: String,
    val image: Int,
    val price: Double,
    val qty: Int
)