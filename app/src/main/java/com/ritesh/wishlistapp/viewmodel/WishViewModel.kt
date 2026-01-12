package com.ritesh.wishlistapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ritesh.wishlistapp.data.model.Wish
import com.ritesh.wishlistapp.data.repository.WishRepository
import com.ritesh.wishlistapp.di.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WishViewModel(
    private val repository: WishRepository = Graph.wishRepository
): ViewModel() {

    var wishTitle by mutableStateOf("")
    var wishDescription by mutableStateOf("")

    fun onWishTitleChanged(newWish: String){
        wishTitle = newWish
    }
    fun onWishDescriptionChanged(newDesc: String){
        wishDescription = newDesc
    }

    lateinit var getAllWishes: Flow<List<Wish>>

    init {
        viewModelScope.launch {
            getAllWishes = repository.getAllWishes()
        }
    }

    fun addWish(wish: Wish){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWish(wish)
        }
    }

    fun updateWish(wish: Wish) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateWish(wish)
        }
    }

    fun getWishById(id: Int): Flow<Wish?> {
        return repository.getWishById(id)
    }

    fun deleteWish(wish: Wish){
        viewModelScope.launch {
            repository.deleteWish(wish)
        }
    }
}