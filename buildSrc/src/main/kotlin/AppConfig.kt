import org.gradle.api.Project

object AppConfig {
    val applicationId = "com.kobeissidev.jetpackcomposepokedex"

    const val compileSDK = 31
    const val buildTools = "31.0.0"
    const val minSDK = 24
    const val targetSDK = compileSDK

    const val versionCode = 1
    const val versionName = "1.0.0"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"

    const val buildType = "release"
    const val defaultProguardFile = "proguard-android-optimize.txt"
    const val proguardConsumerRules =  "proguard-rules.pro"

    const val kotlinJvmTarget = "1.8"

    val Project.processorOptionsMap get() = mapOf(
        "room.schemaLocation" to "$projectDir/schemas",
        "room.incremental" to "true",
        "room.expandProjection" to "true"
    )
}
