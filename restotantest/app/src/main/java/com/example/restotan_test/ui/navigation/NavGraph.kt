package com.example.restotan_test.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.restotan_test.data.ProfilePreferences
import com.example.restotan_test.ui.screens.*

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val prefs = remember { ProfilePreferences(context) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            // Only show bottom bar for main destinations
            val mainDestinations = listOf("home", "menu", "profile")
            if (currentDestination?.route in mainDestinations) {
                NavigationBar {
                    val items = listOf(
                        Triple("home", "Home", Icons.Default.Home),
                        Triple("menu", "Menu", Icons.AutoMirrored.Filled.MenuBook),
                        Triple("profile", "Profile", Icons.Default.Person)
                    )
                    items.forEach { (route, label, icon) ->
                        NavigationBarItem(
                            icon = { Icon(icon, contentDescription = label) },
                            label = { Text(label) },
                            selected = currentDestination?.hierarchy?.any { it.route == route } == true,
                            onClick = {
                                navController.navigate(route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(navController = navController, prefs = prefs)
            }
            composable("menu") {
                MenuScreen(navController = navController)
            }
            composable(
                route = "menu/{menuId}",
                arguments = listOf(navArgument("menuId") { type = NavType.StringType })
            ) { backStackEntry ->
                DetailMenuScreen(navController = navController, menuId = backStackEntry.arguments?.getString("menuId"))
            }
            composable("profile") {
                ProfileScreen(navController = navController, prefs = prefs)
            }
            composable("edit_profile") {
                EditProfileScreen(navController = navController, prefs = prefs)
            }
        }
    }
}
