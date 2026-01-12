package com.ritesh.wishlistapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
        composable(
            route = Screen.AddWishScreen.route + "/{id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                    defaultValue = 0
                    nullable = false
                }
            )
        ) { entry ->
            val id = if (entry.arguments != null) entry.arguments!!.getInt("id") else 0
            AddEditWishScreen(
                id = id,
                viewModel = viewModel,
                navController = navController
            )
        }
    }

}