package com.example.sleepsoundsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sleepsoundsapp.screens.BoardingScreen
import com.example.sleepsoundsapp.screens.HomeScreen

//@ExperimentalAnimationApi
//@ExperimentalPagerApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Boarding.route
    ) {
        composable(route = Screen.Boarding.route) {
            BoardingScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
//            HomeScreen(navController = navController)
        }
    }
}