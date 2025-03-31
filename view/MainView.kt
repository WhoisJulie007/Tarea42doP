package com.example.segundoparcial.view

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.segundoparcial.models.Preferencias
import kotlinx.coroutines.launch

@Composable

fun MainView(navController: NavHostController) {
    var checked by remember{
        mutableStateOf(false)
    }
    var showDialog by remember{
        mutableStateOf(false)
    }
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableIntStateOf(0)
    }
    var height by remember {
        mutableFloatStateOf(0.0f)
    }
    var money by remember {
        mutableFloatStateOf(0.0f)
    }



    val context: Context = LocalContext.current
    val preferences = Preferencias(context)
    val corrutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Teclea tu nombre") }
        )
        TextField(
            value = age.toString(),
            onValueChange = { age = it.toIntOrNull() ?: 0 },
            label = { Text("Teclea tu nombre") }
        )

        TextField(
            value = height.toString(),
            onValueChange = { height = it.toFloatOrNull() ?: 0.0f },
            label = { Text("Teclea tu nombre") }
        )

        TextField(
            value = money.toString(),
            onValueChange = { money = it.toFloatOrNull() ?: 0.0f },
            label = { Text("Teclea tu nombre") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            if (checked) {
                corrutineScope.launch {
                    preferences.savePersonData(name, age, height, money)
                }
                navController.navigate("Productos")
            } else {
                corrutineScope.launch {
                    preferences.clearSession()
                }
                showDialog = true
            }
        }) {
            Text(text = "Guardar")
        }
        Log.d("DEBUG", "Datos: $name, $age, $height, $money")
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Informacion") },
                text = {
                    Column {
                        Text(text = "Tienes que activar el boton para guardar los datos")
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

