object Dependencies {

    val implementations = Versions.Implementations.run {
        arrayListOf<String>().apply {
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
    }

    val api = Versions.API.run {
        // Temp workaround for hilt + room bug
        arrayListOf<String>().apply {
            add("androidx.room:room-runtime:$room")
        }
    }

    val testImplementations = Versions.TestImplementations.run {
        arrayListOf<String>().apply {
            add("junit:junit:$junit")
        }
    }

    val androidTestImplementations = Versions.AndroidTestImplementations.run {
        arrayListOf<String>().apply {
            add("androidx.test.ext:junit:$extJunit")
            add("androidx.test.espresso:espresso-core:$espresso")
            add("androidx.compose.ui:ui-test-junit4:$compose")
        }
    }

    val appPlugins = arrayListOf<String>().apply {
        add("com.android.application")
        add("kotlin-android")
        add("kotlin-kapt")
        add("kotlin-parcelize")
        add("dagger.hilt.android.plugin")
    }

    val rootPlugins = Versions.Plugins.run {
        arrayListOf<String>().apply {
            add("com.android.tools.build:gradle:$buildGradle")
            add("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin")
            add("com.google.dagger:hilt-android-gradle-plugin:$hilt")
        }
    }

    val kaptProcessors = Versions.Kapt.run {
        arrayListOf<String>().apply {
            add("com.google.dagger:hilt-android-compiler:$hilt")
            add("androidx.room:room-compiler:$room")
            add("io.github.kaustubhpatange:autobindings-compiler:$autobindings")
            add("com.squareup.moshi:moshi-kotlin-codegen:$moshi")
        }
    }
}