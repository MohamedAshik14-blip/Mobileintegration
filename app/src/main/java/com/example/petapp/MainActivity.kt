package com.example.petapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.petapp.ui.LoginScreen
import com.example.petapp.ui.PetListScreen
import com.example.petapp.ui.PetTrackingScreen
import com.example.petapp.ui.theme.PetAppTheme
import com.example.petapp.ui.PetViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val petViewModel: PetViewModel = viewModel()

            PetAppTheme {
                AppNavigation(petViewModel)
            }
        }
    }
}



@Composable
fun AppNavigation(petViewModel: PetViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("pet_list") {
            PetListScreen(petViewModel = petViewModel, navController = navController)
        }
        composable(
            route = "pet_tracking/{latitude},{longitude}",
            arguments = listOf(
                navArgument("latitude") { type = NavType.FloatType },
                navArgument("longitude") { type = NavType.FloatType }
            )
        ) { backStackEntry ->
            val latitude = backStackEntry.arguments?.getFloat("latitude") ?: 0f
            val longitude = backStackEntry.arguments?.getFloat("longitude") ?: 0f


            PetTrackingScreen(latitude = latitude, longitude = longitude, navController = navController)
        }
    }
}

