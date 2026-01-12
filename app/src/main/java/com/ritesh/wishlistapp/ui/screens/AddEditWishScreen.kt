package com.ritesh.wishlistapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ritesh.wishlistapp.ui.components.AppBar
import com.ritesh.wishlistapp.R
import com.ritesh.wishlistapp.ui.components.WishTextField
import com.ritesh.wishlistapp.viewmodel.WishViewModel

@Composable
fun AddEditWishScreen(
    id: Int,
    viewModel: WishViewModel,
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            AppBar(
                title = if (id != 0) stringResource(id = R.string.title_Update_wish)
                else stringResource(id = R.string.title_add_wish),
            )
            { navController.navigateUp() }
        }
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
                    if (viewModel.wishTitle.isNotEmpty() && viewModel.wishDescription.isNotEmpty()) {
                        // UPDATE wish
                    } else {
                        // ADD wish
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_700),
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