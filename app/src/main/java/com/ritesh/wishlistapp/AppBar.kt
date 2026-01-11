package com.ritesh.wishlistapp

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    onBackNavClicked: () -> Unit = {}
) {
    val navigationIcon: (@Composable () -> Unit) = {
        if (!title.contains("Wishlist")){
            IconButton(
                onClick = {onBackNavClicked()}
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        } else {
            null
        }
    }

    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .heightIn(max = 24.dp),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace
                ),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = navigationIcon,
        colors = TopAppBarColors(
            containerColor = colorResource(id = R.color.teal_200),
            scrolledContainerColor = colorResource(id = R.color.teal_200),
            navigationIconContentColor = colorResource(id = R.color.white) ,
            titleContentColor = colorResource(id = R.color.white),
            actionIconContentColor = Color.Transparent
        )
    )
}