package com.ippon.victorultimate.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ippon.victorultimate.ui.models.Destination
import com.ippon.victorultimate.ui.screens.CardDetailScreen
import com.ippon.victorultimate.ui.screens.HomeScreen
import com.ippon.victorultimate.ui.view_models.CardDetailViewModel
import com.ippon.victorultimate.ui.view_models.CardViewModel

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen.route
    ) {
        composable(
            route = Destination.HomeScreen.fullRoute(),
            arguments = Destination.HomeScreen.arguments,
        ) {
            val cardViewModel: CardViewModel = hiltViewModel()
            val cardModels by cardViewModel.cardModels.collectAsState()
            HomeScreen(
                modifier = Modifier.fillMaxSize(),
                cardModels = cardModels,
                onClick = {
                    navController.navigate(
                        "${Destination.CardDetail.route}/$it"
                    )
                }
            )
        }
        composable(
            route = Destination.CardDetail.fullRoute(),
            arguments = Destination.CardDetail.arguments,
        ) {
            val cardDetailViewModel: CardDetailViewModel = hiltViewModel()
            val cardDetailModel by cardDetailViewModel.cardDetailModel.collectAsState()
            CardDetailScreen(
                cardDetailModel = cardDetailModel,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}