package com.ritesh.wishlistapp.data.repository

import com.ritesh.wishlistapp.data.local.WishDao
import com.ritesh.wishlistapp.data.model.Wish
import kotlinx.coroutines.flow.Flow

class WishRepository(
    private val wishDao: WishDao
) {

    suspend fun addWish(wish: Wish) = wishDao.addWish(wish = wish)

    fun getAllWishes(): Flow<List<Wish>> = wishDao.getAllWishes()

    fun getWishById(id: Int) : Flow<Wish?> = wishDao.getWishById(id)

    suspend fun updateWish(wish: Wish) = wishDao.updateWish(wish = wish)

    suspend fun deleteWish(wish: Wish) = wishDao.deleteWish(wish = wish)
}