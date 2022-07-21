val composeVersion = "1.2.0-rc03"

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp").version("1.6.21-1.0.5")
}
android {
    namespace = "com.kobeissidev.jetpackcomposepokedex"
}

android.run {
    compileSdk = 31

    defaultConfig.run {
        applicationId("com.kobeissidev.jetpackcomposepokedex")
        minSdk = 24
        targetSdk = compileSdk
        versionCode(1)
        versionName("1.0.0")
        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        javaCompileOptions.annotationProcessorOptions.arguments.putAll(
            mapOf(
                "room.exportSchema" to "false",
                "room.incremental" to "true",
                "room.expandProjection" to "true"
            )
        )
    }

    buildTypes.run {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    composeOptions.kotlinCompilerExtensionVersion = composeVersion
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    buildFeatures.compose = true
}

dependencies {
    // Temp workaround for hilt + room bug
    api("androidx.room:room-runtime:2.5.0-alpha02")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
    implementation("androidx.core:core-ktx:1.9.0-alpha05")
    implementation("androidx.appcompat:appcompat:1.6.0-alpha05")
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.43")
    // Used for hiltViewModel() in Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    // Jetpack Compose
    implementation("androidx.compose.ui:ui:$composeVersion")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    // implementations support for setContent in activities
    implementation("androidx.activity:activity-compose:1.5.0")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    // Material Design
    implementation("androidx.compose.material:material:$composeVersion")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    // Accompanist to supplement Jetpack Compose
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.24.8-beta")
    // Navigation in Compose
    implementation("androidx.navigation:navigation-compose:2.5.0")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.24.8-beta")
    // Used for image loading in Compose
    implementation("io.coil-kt:coil-compose:2.1.0")
    // Retrofit + Moshi
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.moshi:moshi:1.13.0")
    // Kotlinx Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    // Room
    implementation("androidx.room:room-ktx:2.5.0-alpha02")
    implementation("androidx.room:room-paging:2.5.0-alpha02")
    // Paging Compose
    implementation("androidx.paging:paging-compose:1.0.0-alpha15")
    // Swipe to Refresh
    implementation("com.google.accompanist:accompanist-swiperefresh:0.24.8-beta")
    // Pager for creating tabbed layout
    implementation("com.google.accompanist:accompanist-pager:0.24.8-beta")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.24.8-beta")
    // Color extraction from image
    implementation("androidx.palette:palette-ktx:1.0.0")
    // Logging
    implementation("com.jakewharton.timber:timber:5.0.1")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    kapt("com.google.dagger:hilt-android-compiler:2.43")
    ksp("androidx.room:room-compiler:2.5.0-alpha02")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
}