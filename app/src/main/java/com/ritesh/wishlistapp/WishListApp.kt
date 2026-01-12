package com.ritesh.wishlistapp

import android.app.Application
import com.ritesh.wishlistapp.di.Graph

class WishListApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}