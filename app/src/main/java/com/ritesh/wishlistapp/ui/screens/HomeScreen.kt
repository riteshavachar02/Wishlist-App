package com.ritesh.wishlistapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ritesh.wishlistapp.R
import com.ritesh.wishlistapp.data.model.Wish
import com.ritesh.wishlistapp.ui.components.AppBar
import com.ritesh.wishlistapp.ui.components.SwipeToDeleteContainer
import com.ritesh.wishlistapp.ui.components.WishItem
import com.ritesh.wishlistapp.ui.navigation.Screen
import com.ritesh.wishlistapp.viewmodel.WishViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: WishViewModel
) {
    val wishList = viewModel.getAllWishes.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    var recentlyDeletedWish by remember { mutableStateOf<Wish?>(null) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(title = "Wishlist")
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddWishScreen.route + "/0")
                },
                modifier = Modifier.padding(20.dp),
                backgroundColor = colorResource(id = R.color.teal_200)
            ) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        },
        backgroundColor = Color.Black
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(wishList.value, key = { it.id }) { wish ->

                SwipeToDeleteContainer(
                    item = wish,
                    onDelete = {
                        recentlyDeletedWish = wish
                        viewModel.deleteWish(wish)

                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                message = "Wish deleted",
                                actionLabel = "Undo"
                            )

                            if (result == SnackbarResult.ActionPerformed) {
                                recentlyDeletedWish?.let {
                                    viewModel.addWish(it)
                                }
                            }
                        }
                    },
                    onUndo = {}
                ) {
                    WishItem(wish = wish) {
                        navController.navigate(
                            Screen.AddWishScreen.route + "/${wish.id}"
                        )
                    }
                }
            }
        }
    }
}
