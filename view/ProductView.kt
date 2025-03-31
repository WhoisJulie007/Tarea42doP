package com.example.segundoparcial.view

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.segundoparcial.R
import com.example.segundoparcial.models.Preferencias
import com.example.segundoparcial.models.ProductModel
import com.example.segundoparcial.viewsmodels.ProductViewModel
import kotlinx.coroutines.launch


@Preview(showBackground = true)
@Composable
fun ProductPreview(){

    val product = ProductModel(id = 1, name = "Pasta alfredo", description = "La pasta mas rica", price = 199.0f, image = R.drawable.pasta1)
    ProductView(product)
}
@Composable

fun ProductView(product: ProductModel){
    val context: Context = LocalContext.current
    val preferences = Preferencias(context)
    val corrutineScope = rememberCoroutineScope()
    val productViewModel : ProductViewModel = ProductViewModel()
    val money = preferences.money.collectAsState(initial = 0.0f)
    val pobreton = product.price > money.value

    Card(modifier = Modifier.fillMaxWidth()){
        Row(modifier = Modifier.fillMaxWidth()){
            Image(painter = painterResource(id = product.image),
                contentDescription = "",
                modifier = Modifier.size(90.dp),
                contentScale = ContentScale.Crop)
            Column (modifier = Modifier.padding(10.dp)){
                Text(text = product.name, fontSize = 24.sp)
                Text(text = product.description ?: "Sin descripción", fontSize = 18.sp, color = Color.DarkGray)
                Text(text = "${product.price} MXN", fontSize = 23.sp, textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())

            }
        }
        Button(onClick = {
            if (!pobreton) {  // Si no es pobreton, puede comprar
                val resta = money.value - product.price
                corrutineScope.launch {
                    preferences.restarDinero(resta)
                }

            }

//

        }, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ), enabled = !pobreton ){
            Text(text = "Comprar")

        }

    }
}
