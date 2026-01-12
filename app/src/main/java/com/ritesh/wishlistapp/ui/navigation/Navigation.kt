package com.ritesh.wishlistapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ritesh.wishlistapp.ui.navigation.Screen
import com.ritesh.wishlistapp.viewmodel.WishViewModel
import com.ritesh.wishlistapp.ui.screens.AddEditWishScreen
import com.ritesh.wishlistapp.ui.screens.HomeScreen

@Composable
fun Navigation (
    viewModel: WishViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(route = Screen.AddWishScreen.route) {
            AddEditWishScreen(
                id = 0,
                viewModel = viewModel,
                navController = navController
            )
        }
    }

}