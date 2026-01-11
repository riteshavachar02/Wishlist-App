package com.ritesh.wishlistapp.data

data class Wish(
    val id: Int,
    val title: String,
    val description: String
)

object DummyWish{
    val wishList = listOf(
        Wish(1, "Item 1", "Description 1"),
        Wish(2, "Item 2", "Description 2"),
        Wish(3, "Item 3", "Description 3"),
        Wish(4, "Item 4", "Description 4"),
    )
}
