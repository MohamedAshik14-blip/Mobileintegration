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

//petcard composable function
@Composable
fun PetCard(pet: Pet, navController: NavController) {
    val isExpanded = remember {mutableStateOf(false)} ////if card is expanded then the animation occurs

    val animatedElevation by animateDpAsState(
        targetValue = if (isExpanded.value) 12.dp else 8.dp,
        /////tween specifies an animation with a duration of 300 milliseconds
        animationSpec = tween(durationMillis = 300)
    )
}