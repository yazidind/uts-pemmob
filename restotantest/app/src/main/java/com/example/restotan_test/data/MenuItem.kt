package com.example.restotan_test.data

/**
 * MenuItem sekarang bukan lagi 'class', melainkan hanya alias untuk Map.
 */
typealias MenuItem = Map<String, Any>

/**
 * Fungsi untuk membuat MenuItem (Bertindak seperti constructor).
 */
fun createMenuItem(
    id: String,
    name: String,
    price: Int,
    description: String,
    imageRes: Int
): MenuItem = mapOf(
    "id" to id,
    "name" to name,
    "price" to price,
    "description" to description,
    "imageRes" to imageRes
)

/**
 * Extension properties agar kita tetap bisa memanggil item.name, item.price, dll.
 * Ini menghindari penggunaan 'class' tapi tetap memudahkan di UI.
 */
val MenuItem.id: String get() = this["id"] as String
val MenuItem.name: String get() = this["name"] as String
val MenuItem.price: Int get() = this["price"] as Int
val MenuItem.description: String get() = this["description"] as String
val MenuItem.imageRes: Int get() = this["imageRes"] as Int
