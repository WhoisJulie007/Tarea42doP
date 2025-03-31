package com.example.segundoparcial.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.segundoparcial.models.Preferencias
import com.example.segundoparcial.view.ListProductView
import com.example.segundoparcial.view.MainView
import com.example.segundoparcial.view.ProductView
import com.example.segundoparcial.viewsmodels.ProductViewModel


@Composable()
@Preview(showBackground = true)

fun NavigationManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Inicio") {
        //Aqui hay que poner los nombre de rutas y su componente/vista respectiva
        composable(route = "Inicio"){
            MainView(navController)

        }
        composable(route = "Productos"){
            ListProductView(productViewModel = ProductViewModel())

        }


    }

}