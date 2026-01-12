package com.ritesh.wishlistapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ritesh.wishlistapp.R
import com.ritesh.wishlistapp.data.model.Wish
import com.ritesh.wishlistapp.ui.components.AppBar
import com.ritesh.wishlistapp.ui.components.WishTextField
import com.ritesh.wishlistapp.viewmodel.WishViewModel
import kotlinx.coroutines.launch

@Composable
fun AddEditWishScreen(
    id: Int,
    viewModel: WishViewModel,
    navController: NavHostController
) {

    var snackMessage by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    if (id != 0) {
        val wish = viewModel
            .getWishById(id)
            .collectAsState(initial = Wish(id, "", ""))

        viewModel.wishTitle = wish.value?.title.toString()
        viewModel.wishDescription = wish.value?.description.toString()
    } else {
        viewModel.wishTitle = ""
        viewModel.wishDescription = ""
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                title = if (id != 0) stringResource(id = R.string.title_Update_wish)
                else stringResource(id = R.string.title_add_wish),
            )
            { navController.navigateUp() }
        },
        backgroundColor = Color.Black
    ) {
        Column(
            modifier = Modifier
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            WishTextField(
                label = "Tittle",
                value = viewModel.wishTitle,
                onValueChanged = {
                    viewModel.onWishTitleChanged(it)
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            WishTextField(
                label = "Description",
                value = viewModel.wishDescription,
                onValueChanged = {
                    viewModel.onWishDescriptionChanged(it)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    if (viewModel.wishTitle.isBlank() || viewModel.wishDescription.isBlank()) {
                        scope.launch {
                            scaffoldState.snackbarHostState
                                .showSnackbar("Please enter all fields")
                        }
                        return@Button
                    }
                    if (id != 0) {
                        // UPDATE wish
                        viewModel.updateWish(
                            Wish(
                                id = id,
                                title = viewModel.wishTitle,
                                description = viewModel.wishDescription
                            )
                        )
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Wish Updated.")
                            navController.navigateUp()
                        }

                    } else {
                        // ADD wish
                        viewModel.addWish(
                            Wish(
                                title = viewModel.wishTitle.trim(),
                                description = viewModel.wishDescription.trim()
                            )
                        )
                        viewModel.wishTitle = ""
                        viewModel.wishDescription = ""
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("Wish Created.")
                            navController.navigateUp()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200),
                    contentColor = colorResource(id = R.color.white)
                )
            ) {
                Text(
                    text = if (id != 0) stringResource(id = R.string.title_Update_wish)
                    else stringResource(id = R.string.title_add_wish),
                    fontSize = 18.sp
                )
            }
        }
    }
}