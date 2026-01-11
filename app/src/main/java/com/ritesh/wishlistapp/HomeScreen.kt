package com.ritesh.wishlistapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ritesh.wishlistapp.data.DummyWish

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: WishViewModel
){

    Scaffold(
        topBar = {
            AppBar(
                title = "Wishlist"
            )},
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddWishScreen.route)
                },
                modifier = Modifier
                    .padding(20.dp),
                containerColor = colorResource(id = R.color.teal_200)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            items(DummyWish.wishList) {
                wish->
                WishItem(
                    wish = wish,
                )
            }

        }
    }
}