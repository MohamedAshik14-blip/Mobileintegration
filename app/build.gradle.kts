plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.petapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.petapp"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation ("androidx.compose.ui:ui:1.5.0")
    implementation ("androidx.compose.material:material:1.5.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.5.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.0")
    implementation ("androidx.activity:activity-compose:1.7.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.4")
    implementation ("androidx.room:room-runtime:2.5.1")
    implementation ("androidx.room:room-ktx:2.5.1")
    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("androidx.compose.ui:ui:1.5.0" )// Jetpack Compose UI
    implementation ("androidx.compose.material3:material3:1.0.1") // Material 3
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0") // ViewModel
    implementation ("io.coil-kt:coil-compose:2.4.0") // Coil for image loading
    implementation ("androidx.compose.foundation:foundation:1.5.0" )// Foundation (for LazyColumn, etc.)
    implementation ("androidx.compose.material:material:1.5.0" )// Material Components
    implementation ("androidx.activity:activity-compose:1.6.0") // For using Compose in Activity
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0") // for ViewModel
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.0")
    implementation ("androidx.compose.ui:ui:1.3.0") // for Jetpack Compose
    implementation ("androidx.compose.material3:material3:1.0.0") // for Material UI
    implementation ("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0") // Gson Converter for Retrofit
    implementation ("io.coil-kt:coil-compose:2.1.0") // Coil for image loading

}