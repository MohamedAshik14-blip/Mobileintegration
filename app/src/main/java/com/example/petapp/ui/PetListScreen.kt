package com.example.petapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.petapp.model.Pet
import com.example.petapp.ui.theme.PetAppTheme

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

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
}}

