package com.ritesh.wishlistapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ritesh.wishlistapp.R
import com.ritesh.wishlistapp.data.model.Wish

@Composable
fun WishItem(
    wish: Wish,
    onWishClick: (Wish) -> Unit = {}
) {
    Card(
        onClick = { onWishClick(wish) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
            ),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.wish_item),
            contentColor = colorResource(id = R.color.black)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = wish.title,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = wish.description,
                fontWeight = FontWeight.Light
            )
        }
    }
}