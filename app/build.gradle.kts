plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
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
                "room.schemaLocation" to "$projectDir/schemas",
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
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    composeOptions.kotlinCompilerExtensionVersion = "1.1.0-alpha01"
    kotlinOptions.jvmTarget = "1.8"
    buildFeatures.compose = true
}

dependencies {
    // Temp workaround for hilt + room bug
    api("androidx.room:room-runtime:2.4.0-alpha04")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
    implementation("androidx.core:core-ktx:1.7.0-alpha01")
    implementation("androidx.appcompat:appcompat:1.4.0-alpha03")
    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.38.1")
    // Used for hiltViewModel() in Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-alpha03")
    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.1.0-alpha01")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.1.0-alpha01")
    implementation("androidx.compose.runtime:runtime:1.1.0-alpha01")
    // implementations support for setContent in activities
    implementation("androidx.activity:activity-compose:1.3.1")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.1.0-alpha01")
    // Material Design
    implementation("androidx.compose.material:material:1.1.0-alpha01")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:1.1.0-alpha01")
    implementation("androidx.compose.material:material-icons-extended:1.1.0-alpha01")
    // Accompanist to supplement Jetpack Compose
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.16.0")
    // Navigation in Compose
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha06")
    implementation("com.google.accompanist:accompanist-navigation-animation:0.16.0")
    // Used for image loading in Compose
    implementation("io.coil-kt:coil-compose:1.3.2")
    // Retrofit + Moshi
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.moshi:moshi:1.12.0")
    // Kotlinx Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1")
    // Room
    implementation("androidx.room:room-ktx:2.4.0-alpha04")
    implementation("androidx.room:room-paging:2.4.0-alpha04")
    // Generates the type converters for room using annotations
    implementation("io.github.kaustubhpatange:autobindings:1.1-beta03")
    // Paging Compose
    implementation("androidx.paging:paging-compose:1.0.0-alpha12")
    // Swipe to Refresh
    implementation("com.google.accompanist:accompanist-swiperefresh:0.16.0")
    // Pager for creating tabbed layout
    implementation("com.google.accompanist:accompanist-pager:0.16.0")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.16.1")
    // Color extraction from image
    implementation("androidx.palette:palette-ktx:1.0.0")
    // Logging
    implementation("com.jakewharton.timber:timber:4.7.1")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.0-alpha01")

    kapt("com.google.dagger:hilt-android-compiler:2.38.1")
    kapt("androidx.room:room-compiler:2.4.0-alpha04")
    kapt("io.github.kaustubhpatange:autobindings-compiler:1.1-beta03")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
}