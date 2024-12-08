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



@Preview(showBackground = true)
@Composable
fun PetListScreenPreview() {
    PetAppTheme {
        PetListScreen(pets = listOf(
            Pet("Buddy", "https://www.dogstrust.ie/images/800x600/assets/2022-08/sophia_sbt_puppy_leeds_dogstrust.jpg", 200, 52.5, 13.4),
            Pet("Luna", "https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb_square.jpg", 150, 52.6, 13.5)
        ))
    }
}

