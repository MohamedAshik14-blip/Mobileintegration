package com.example.petapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.petapp.PetViewModel
import androidx.compose.ui.tooling.preview.Preview

import com.example.petapp.model.Pet
import com.example.petapp.ui.theme.PetAppTheme

@Composable
fun PetListScreen(viewModel: PetViewModel = viewModel()) {
    val pets = viewModel.pets.collectAsState().value
    PetListScreen(pets = pets)
}

@Composable
fun PetListScreen(pets: List<Pet>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pets) { pet ->
            PetCard(pet)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PetListScreenPreview() {
    val samplePets = listOf(
        Pet("Buddy", "https://www.dogstrust.ie/images/800x600/assets/2022-08/sophia_sbt_puppy_leeds_dogstrust.jpg", 200, 52.5, 13.4),
        Pet("Luna", "https://i.natgeofe.com/n/4f5aaece-3300-41a4-b2a8-ed2708a0a27c/domestic-dog_thumb_square.jpg", 150, 52.6, 13.5)
    )
    PetAppTheme {
        PetListScreen(pets = samplePets)
    }
}