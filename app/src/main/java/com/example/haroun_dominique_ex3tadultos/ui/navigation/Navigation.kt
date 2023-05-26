package com.example.haroun_dominique_ex3tadultos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.haroun_dominique_ex3tadultos.MenuScreen
import com.example.haroun_dominique_ex3tadultos.ui.ej01.elements.Ej01
import com.example.haroun_dominique_ex3tadultos.ui.ej02.elements.Ej02
import com.example.haroun_dominique_ex3tadultos.ui.ej03.view.Ej03

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) { MenuScreen(navController) }
        composable(route = Screens.Ejercicio01.route) { Ej01() }
        composable(route = Screens.Ejercicio02.route) { Ej02() }
        composable(route = Screens.Ejercicio03.route) { Ej03() }
    }
}