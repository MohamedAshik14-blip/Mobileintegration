package com.example.petapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable    //gets list of pets from petviewmodel
fun PetListScreen(petViewModel: PetViewModel, navController: NavController) {
    val pets = petViewModel.pets.collectAsState().value
    val showHeading=remember{true}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            //adjust height of column to wrap the contents
            .wrapContentHeight(Alignment.CenterVertically)
    ) {

        //crossfade animation
        Crossfade(
            targetState = showHeading, //when target state changes, the fade effect is shown
            animationSpec = tween(durationMillis = 1000)
        //////lambda function define the ui for each targetstate.if true, displays text
        ) { targetState ->
            if (targetState) {
                Text(
                    text = "Pet Dashboard",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 24.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }





        //lazycolumn for scrollable list of pets
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            //lambda that goes over pets list. creates a card for each pet in the list
            items(pets) { pet -> PetCard(pet=pet, navController=navController)
            }
        }

}}

