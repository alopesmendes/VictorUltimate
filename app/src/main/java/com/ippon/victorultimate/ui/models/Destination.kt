package com.ippon.victorultimate.ui.models

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Destination(
    val route: String,
    val arguments: List<NamedNavArgument>,
) {

    abstract fun fullRoute(): String
    data object HomeScreen: Destination(
        route = "home",
        arguments = emptyList()
    ) {
        override fun fullRoute(): String {
            return "home"
        }
    }

    data object CardDetail: Destination(
        route = "detail",
        arguments = listOf(
            navArgument(
                name = "id"
            ) { type = NavType.IntType }
        )
    ) {
        override fun fullRoute(): String {
            return "detail/{id}"
        }
    }
}
