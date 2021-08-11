ext {
    this["buildGradle"] = "7.1.0-alpha03"
    this["kotlin"] = "1.5.21"
    this["hilt"] = "2.38.1"
    this["coreKtx"] = "1.7.0-alpha01"
    this["appcompat"] = "1.4.0-alpha03"
    this["navigation"] = "2.4.0-alpha06"
    this["compose"] = "1.1.0-alpha01"
    this["activityCompose"] = "1.3.1"
    this["accompanist"] = "0.16.0"
    this["coil"] = "1.3.2"
    this["hiltNavigation"] = "1.0.0-alpha03"
    this["retrofit"] = "2.9.0"
    this["loggingInterceptor"] = "4.9.1"
    this["moshi"] = "1.12.0"
    this["coroutines"] = "1.5.1"
    this["room"] = "2.4.0-alpha04"
    this["autobindings"] = "1.1-beta03"
    this["pagingCompose"] = "1.0.0-alpha12"
    this["palette"] = "1.0.0"
    this["timber"] = "4.7.1"
    this["junit"] = "4.13.2"
    this["extJunit"] = "1.1.3"
    this["espresso"] = "3.4.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0-alpha03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) { delete(rootProject.buildDir) }

/**
 * Allows the use of experimental APIs
 */
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}