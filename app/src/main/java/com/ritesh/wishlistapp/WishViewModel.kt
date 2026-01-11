package com.ritesh.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel: ViewModel() {

    var wishTitle by mutableStateOf("")
    var wishDescription by mutableStateOf("")

    fun onWishTitleChanged(newWish: String){
        wishTitle = newWish
    }
    fun onWishDescriptionChanged(newDesc: String){
        wishDescription = newDesc
    }
}