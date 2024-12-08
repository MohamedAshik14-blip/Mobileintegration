package com.example.petapp.ui

import android.content.Context
import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetTrackingScreen(latitude: Float, longitude: Float, navController: NavController) {
    val context = LocalContext.current

    val callback = OnMapReadyCallback { googleMap: GoogleMap ->
        val petLocation = LatLng(latitude.toDouble(), longitude.toDouble())
        googleMap.addMarker(MarkerOptions().position(petLocation).title("Pet Location"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(petLocation, 15f))
    }
     val mapView = rememberMapViewWithLifecycle(context)

    Column(modifier = Modifier.fillMaxSize()) {

        TopAppBar(
            title = { Text("Track Pet") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            }
        )
 Box(modifier = Modifier.weight(1f)) {
            AndroidView(
                factory = { mapView },
                modifier = Modifier.fillMaxSize(),
                update = {
                    mapView.getMapAsync(callback)
                }
            )
        }
  Spacer(modifier = Modifier.height(8.dp))


        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { navController.popBackStack() }
        ) {
            Text("Back to Pet List")
        }
    }
}
