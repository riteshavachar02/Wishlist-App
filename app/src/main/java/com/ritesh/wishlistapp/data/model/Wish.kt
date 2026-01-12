package com.ritesh.wishlistapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish_table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "wish_title")
    val title: String,
    @ColumnInfo(name = "wish_desc")
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
