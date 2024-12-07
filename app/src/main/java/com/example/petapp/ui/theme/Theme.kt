package com.example.petapp.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColors = lightColors(
    primary = Purple500,
    secondary = Teal200
)

@Composable
fun PetAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        content = content
    )
}
