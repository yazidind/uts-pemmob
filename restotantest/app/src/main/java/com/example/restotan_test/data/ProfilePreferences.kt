package com.example.restotan_test.data

import android.content.Context

data class RestaurantProfile(
    val name: String = "Restoran Kita",
    val address: String = "",
    val description: String = "",
    val openingHours: String = ""
)

class ProfilePreferences(context: Context) {
    private val prefs = context.getSharedPreferences("resto_prefs", Context.MODE_PRIVATE)

    fun saveProfile(profile: RestaurantProfile) {
        prefs.edit().apply {
            putString("name", profile.name)
            putString("address", profile.address)
            putString("description", profile.description)
            putString("hours", profile.openingHours)
            apply()
        }
    }

    fun loadProfile(): RestaurantProfile {
        return RestaurantProfile(
            name = prefs.getString("name", "Restoran Kita") ?: "Restoran Kita",
            address = prefs.getString("address", "") ?: "",
            description = prefs.getString("description", "") ?: "",
            openingHours = prefs.getString("hours", "") ?: ""
        )
    }
}