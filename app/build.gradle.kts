plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.hercryptoapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.hercryptoapp"
        minSdk = 26
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
        // Add these new lines
        // ... other dependencies ...
        implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
        implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
        implementation("io.coil-kt:coil-compose:2.5.0")
        // Compose dependencies
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.activity:activity-compose:1.8.1")
        implementation(platform("androidx.compose:compose-bom:2023.10.01"))
        implementation("androidx.compose.ui:ui")
        implementation("androidx.compose.ui:ui-graphics")
        implementation("androidx.compose.ui:ui-tooling-preview")
        implementation("androidx.compose.material3:material3")

        // MPAndroidChart
        implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

        // Retrofit for API calls
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        // Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}