object Versions {
    object Plugins {
        const val buildGradle = "7.1.0-alpha03"
        const val kotlin = "1.5.21"
        const val hilt = "2.38.1"
    }

    object Implementations {
        const val coreKtx = "1.7.0-alpha01"
        const val appcompat = "1.4.0-alpha03"
        const val navigation = "2.4.0-alpha06"
        const val compose = "1.1.0-alpha01"
        const val activityCompose = "1.3.1"
        const val kotlin = Plugins.kotlin
        const val accompanist = "0.16.0"
        const val coil = "1.3.2"
        const val hilt = Plugins.hilt
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
    }

    object API {
        const val room = Implementations.room
    }

    object TestImplementations {
        const val junit = "4.13.2"
    }

    object AndroidTestImplementations {
        const val extJunit = "1.1.3"
        const val espresso = "3.4.0"
        const val compose = Implementations.compose
    }

    object Kapt {
        const val hilt = Plugins.hilt
        const val room = Implementations.room
        const val autobindings = Implementations.autobindings
        const val moshi = Implementations.moshi
    }
}