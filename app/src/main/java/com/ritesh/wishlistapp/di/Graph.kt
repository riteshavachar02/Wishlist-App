package com.ritesh.wishlistapp.di

import android.content.Context
import androidx.room.Room
import com.ritesh.wishlistapp.data.local.WishDatabase
import com.ritesh.wishlistapp.data.repository.WishRepository

object Graph {

    lateinit var database: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context) {
        database = Room.databaseBuilder(
            context = context,
            WishDatabase::class.java,
            name = "wishlist.db"
        ).build()
    }
}