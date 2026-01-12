package com.ritesh.wishlistapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ritesh.wishlistapp.data.model.Wish
import kotlinx.coroutines.flow.Flow

@Dao
interface WishDao {

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    abstract suspend fun addWish(wish: Wish)

    @Query("SELECT * FROM `wish_table`")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Update
    abstract suspend fun updateWish(wish: Wish)

    @Delete
    abstract suspend fun deleteWish(wish: Wish)

    @Query("SELECT * FROM `wish_table` WHERE id=:id")
    abstract fun getWishById(id: Int): Flow<Wish?>

}