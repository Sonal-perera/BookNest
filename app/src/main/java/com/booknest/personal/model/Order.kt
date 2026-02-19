package com.booknest.community.model

import java.util.Date

data class Order(
    val orderId: String,
    val email:String,
    val date: String,
    val name: String,
    val author: String,
    val image: Int,
    val price: Double,
    val status: String
)