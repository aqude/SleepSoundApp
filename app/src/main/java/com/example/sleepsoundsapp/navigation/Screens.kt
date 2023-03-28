package com.example.sleepsoundsapp.navigation

const val BOARDING_SCREEN = "onboarding_screens"
const val HOME_SCREEN = "home_screen"

sealed class Screen(val route: String) {
    object Boarding : Screen(route = BOARDING_SCREEN)
    object Home : Screen(route = HOME_SCREEN)
}