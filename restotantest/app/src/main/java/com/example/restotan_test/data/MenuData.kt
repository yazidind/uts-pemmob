package com.example.restotan_test.data

import com.example.restotan_test.R

/**
 * Variabel Top-level (Tanpa pembungkus class atau object).
 * Menggunakan fungsi createMenuItem karena MenuItem sekarang adalah Map (bukan class).
 */
object MenuData {
    val items = listOf(
        createMenuItem("1", "Nasi Goreng Spesial", 25000, "Nasi goreng dengan telur, ayam, dan udang", R.drawable.ic_menu_placeholder),
        createMenuItem("2", "Mie Ayam Pangsit", 20000, "Mie ayam dengan pangsit dan kuah kaldu", R.drawable.ic_menu_placeholder),
        createMenuItem("3", "Sate Ayam Madura", 30000, "10 tusuk sate ayam + lontong & bumbu kacang", R.drawable.ic_menu_placeholder),
        createMenuItem("4", "Es Teh Manis", 5000, "Teh manis segar dengan es batu", R.drawable.ic_menu_placeholder),
        createMenuItem("5", "Jus Alpukat", 15000, "Jus alpukat fresh dengan susu coklat", R.drawable.ic_menu_placeholder)
    )
}
