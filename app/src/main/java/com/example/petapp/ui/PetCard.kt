package com.example.petapp.ui
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.petapp.model.Pet
import androidx.compose.animation.core.tween
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter




//petcard composable function
@Composable
fun PetCard(pet: Pet, navController: NavController) {
    val isExpanded = remember {mutableStateOf(false)} ////if card is expanded then the animation occurs
    val animatedElevation by animateDpAsState(
        targetValue = if (isExpanded.value) 12.dp else 8.dp,
        /////tween specifies an animation with a duration of 300 milliseconds
        animationSpec = tween(durationMillis = 300)
    )



    val cardElevation=CardDefaults.elevatedCardElevation(defaultElevation =animatedElevation)
    Card(
        modifier = Modifier
            .fillMaxWidth() ///card expand full width of the container.
            .padding(8.dp)
            .clickable {isExpanded.value = !isExpanded.value},
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = animatedElevation)////sets elevation of card
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                //////using coil to display image
                painter = rememberImagePainter(data = pet.imageUrl),
                contentDescription = "${pet.name}'s image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }}
}