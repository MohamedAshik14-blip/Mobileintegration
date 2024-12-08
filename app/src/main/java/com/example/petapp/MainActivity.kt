package com.example.petapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.petapp.model.Pet
import com.example.petapp.ui.PetListScreen
import com.example.petapp.ui.theme.PetAppTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.runtime.Composable

import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //splash
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContent {
            PetAppTheme {
                PetListScreen()
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

