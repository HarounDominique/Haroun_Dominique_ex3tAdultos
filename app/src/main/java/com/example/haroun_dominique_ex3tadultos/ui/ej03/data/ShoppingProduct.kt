package com.example.haroun_dominique_ex3tadultos.ui.ej03.data

data class ShoppingProduct(val productName: String, val checked: Boolean = false)

fun getFakeShoppingProducts() = List(30) { i -> ShoppingProduct( "Producto $i") }