package com.example.segundoparcial.viewsmodels

import androidx.lifecycle.ViewModel
import com.example.segundoparcial.R
import com.example.segundoparcial.models.ProductModel

class ProductViewModel() : ViewModel() {
    init {
        //obtenerProductos()

    }

    fun obtenerProductos() : List<ProductModel>{
        val producto1 = ProductModel(id = 1,
            name = "Pizza Individual",
            description = "Desde Italia",
            price = 99.0f,
            image = R.drawable.pizza)
        val producto2 = ProductModel(id = 2,
            name = "Pasta Alfredo Indivisual",
            description = "Con mucho queso",
            price = 159.0f,
            image = R.drawable.pasta1)
        val producto3 = ProductModel(id = 3,
            name = "Pasta Pomodoro individual",
            description = "Con el mejor tomate",
            price = 149.0f,
            image = R.drawable.pomodoro)
        val producto4 = ProductModel(id = 4,
            name = "Pizza en pareja",
            description = "Desde Italia con amor",
            price = 199.0f,
            image = R.drawable.pizza)
        val producto5 = ProductModel(id = 5,
            name = "Pasta Alfredo en pareja",
            description = "Con mucho queso y amor",
            price = 199.0f,
            image = R.drawable.pasta1)
        val producto6 = ProductModel(id = 6,
            name = "Pasta Pomodoro en pareja",
            description = "Con el mejor tomate y amor",
            price = 149.0f,
            image = R.drawable.pomodoro)
        val producto7 = ProductModel(id = 7,
            name = "Pizza familia",
            description = "Desde Italia",
            price = 299.0f,
            image = R.drawable.pizza)
        val producto8 = ProductModel(id = 8,
            name = "Pasta Alfredo familiar",
            description = "Con mucho queso",
            price = 359.0f,
            image = R.drawable.pasta1)
        val producto9 = ProductModel(id = 9,
            name = "Pasta Pomodoro familiar",
            description = "Con el mejor tomate",
            price = 299.0f,
            image = R.drawable.pomodoro)
        val producto10 = ProductModel(id = 10,
            name = "Pakete llenes",
            description = "Todo junto para ti",
            price = 599.0f,
            image = R.drawable.pomodoro)
        var productList = listOf<ProductModel>(
            producto1,producto2,producto3,producto4,producto5,producto6, producto7, producto8,producto9,producto10
        )
        return productList


    }
}