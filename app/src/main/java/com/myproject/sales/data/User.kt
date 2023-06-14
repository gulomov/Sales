package com.myproject.sales.data

data class User(
    val name: String? = null,
    val userName: String? = null,
    val products: List<Likes>? = null,
)

data class Likes(
    val name: String? = null,
    val price: Int? = null,
    val productImage: String? = null,
)
