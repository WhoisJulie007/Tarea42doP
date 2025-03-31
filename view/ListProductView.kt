package com.example.segundoparcial.view

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.segundoparcial.models.Preferencias
import com.example.segundoparcial.viewsmodels.ProductViewModel

@Composable

fun ListProductView(productViewModel: ProductViewModel) {
    var showDialog by remember{
        mutableStateOf(false)
    }

    val context: Context = LocalContext.current
    val preferences = Preferencias(context)
    val corrutineScope = rememberCoroutineScope()
    val productViewModel : ProductViewModel = ProductViewModel()
    val name = preferences.name.collectAsState(initial = "")
    val age = preferences.age.collectAsState(initial = 0)
    val height = preferences.height.collectAsState(initial = 0.0f)
    val money = preferences.money.collectAsState(initial = 0.0f)

    Column (modifier = Modifier.fillMaxSize()) {
        LazyColumn() {
            item() {
                Text(text = "Tienes ${money.value} pesos")
            }
            items(productViewModel.obtenerProductos()) { product ->
                ProductView(product = product)

            }
            item(){
                FloatingActionButton(
                    onClick = {
                        showDialog = true
                    },
                    containerColor = Color(0xFF4CAF50),  // Color verde (éxito)
                    contentColor = Color.White,          // Color del icono y texto
                    modifier = Modifier.size(120.dp)                    // Tamaño grande
                ){Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = "Guardar",
                    modifier = Modifier
                        .size(36.dp)             // Tamaño del ícono
                )}

            }

        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Informacion") },
                text = {
                    Column {
                        Text(text = "Nombre ${name.value} Edad ${age.value} Altura ${height.value} dinero ${money.value}")
                    }},
                confirmButton = {
                    Button(
                        onClick = { showDialog = false }
                    ) {
                        Text("Cerrar")
                    }
                }
            )
        }


    }
}