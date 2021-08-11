object Dependencies {
    const val buildGradle = "7.1.0-alpha03"
    const val kotlin = "1.5.21"
    const val hilt = "2.38.1"
    const val coreKtx = "1.7.0-alpha01"
    const val appcompat = "1.4.0-alpha03"
    const val navigation = "2.4.0-alpha06"
    const val compose = "1.1.0-alpha01"
    const val activityCompose = "1.3.1"
    const val accompanist = "0.16.0"
    const val coil = "1.3.2"
    const val hiltNavigation = "1.0.0-alpha03"
    const val retrofit = "2.9.0"
    const val loggingInterceptor = "4.9.1"
    const val moshi = "1.12.0"
    const val coroutines = "1.5.1"
    const val room = "2.4.0-alpha04"
    const val autobindings = "1.1-beta03"
    const val pagingCompose = "1.0.0-alpha12"
    const val palette = "1.0.0"
    const val timber = "4.7.1"
    const val junit = "4.13.2"
    const val extJunit = "1.1.3"
    const val espresso = "3.4.0"

    val implementations = arrayListOf<String>().apply {
        add("org.jetbrains.kotlin:kotlin-stdlib:$kotlin")
        add("androidx.core:core-ktx:$coreKtx")
        add("androidx.appcompat:appcompat:$appcompat")
        // Dagger Hilt
        add("com.google.dagger:hilt-android:$hilt")
        // Used for hiltViewModel() in Compose
        add("androidx.hilt:hilt-navigation-compose:$hiltNavigation")
        // Jetpack Compose
        add("androidx.compose.ui:ui:$compose")
        // Tooling support (Previews, etc.)
        add("androidx.compose.ui:ui-tooling:$compose")
        add("androidx.compose.runtime:runtime:$compose")
        // Adds support for setContent in activities
        add("androidx.activity:activity-compose:$activityCompose")
        // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
        add("androidx.compose.foundation:foundation:$compose")
        // Material Design
        add("androidx.compose.material:material:$compose")
        // Material design icons
        add("androidx.compose.material:material-icons-core:$compose")
        add("androidx.compose.material:material-icons-extended:$compose")
        // Accompanist to supplement Jetpack Compose
        add("com.google.accompanist:accompanist-systemuicontroller:$accompanist")
        // Navigation in Compose
        add("androidx.navigation:navigation-compose:$navigation")
        add("com.google.accompanist:accompanist-navigation-animation:$accompanist")
        // Used for image loading in Compose
        add("io.coil-kt:coil-compose:$coil")
        // Retrofit + Moshi
        add("com.squareup.retrofit2:retrofit:$retrofit")
        add("com.squareup.retrofit2:converter-moshi:$retrofit")
        add("com.squareup.okhttp3:logging-interceptor:$loggingInterceptor")
        add("com.squareup.moshi:moshi:$moshi")
        // Kotlinx Coroutines
        add("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines")
        add("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")
        // Room
        add("androidx.room:room-ktx:$room")
        add("androidx.room:room-paging:$room")
        // Generates the type converters for room using annotations
        add("io.github.kaustubhpatange:autobindings:$autobindings")
        // Paging Compose
        add("androidx.paging:paging-compose:$pagingCompose")
        // Swipe to Refresh
        add("com.google.accompanist:accompanist-swiperefresh:$accompanist")
        // Pager for creating tabbed layout
        add("com.google.accompanist:accompanist-pager:$accompanist")
        add("com.google.accompanist:accompanist-pager-indicators:$accompanist")
        // Color extraction from image
        add("androidx.palette:palette-ktx:$palette")
        // Logging
        add("com.jakewharton.timber:timber:$timber")
    }

    // Temp workaround for hilt + room bug
    val api = arrayListOf<String>().apply {
        add("androidx.room:room-runtime:$room")
    }

    val testImplementations = arrayListOf<String>().apply {
        add("junit:junit:$junit")
    }

    val androidTestImplementations = arrayListOf<String>().apply {
        add("androidx.test.ext:junit:$extJunit")
        add("androidx.test.espresso:espresso-core:$espresso")
        add("androidx.compose.ui:ui-test-junit4:$compose")
    }

    val appPlugins = arrayListOf<String>().apply {
        add("com.android.application")
        add("kotlin-android")
        add("kotlin-kapt")
        add("kotlin-parcelize")
        add("dagger.hilt.android.plugin")
    }

    val rootPlugins = arrayListOf<String>().apply {
        add("com.android.tools.build:gradle:$buildGradle")
        add("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
        add("com.google.dagger:hilt-android-gradle-plugin:$hilt")
    }

    val kaptProcessors = arrayListOf<String>().apply {
        add("com.google.dagger:hilt-android-compiler:$hilt")
        add("androidx.room:room-compiler:$room")
        add("io.github.kaustubhpatange:autobindings-compiler:$autobindings")
        add("com.squareup.moshi:moshi-kotlin-codegen:$moshi")
    }
}