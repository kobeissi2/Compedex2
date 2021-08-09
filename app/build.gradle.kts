plugins { id(Dependencies.appPlugins) }

android.run {
    AppConfig.run {
        compileSdk = compileSDK
        buildToolsVersion = buildTools

        defaultConfig.run {
            applicationId(applicationId)
            minSdk = minSDK
            targetSdk = targetSDK
            versionCode(versionCode)
            versionName(versionName)
            testInstrumentationRunner(androidTestInstrumentation)
            javaCompileOptions.annotationProcessorOptions.arguments.putAll(processorOptionsMap)
        }

        buildTypes.run {
            getByName(buildType) {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile(defaultProguardFile), proguardConsumerRules)
            }
        }

        compileOptions {
            sourceCompatibility(JavaVersion.VERSION_1_8)
            targetCompatibility(JavaVersion.VERSION_1_8)
        }

        composeOptions.kotlinCompilerExtensionVersion = Versions.Implementations.compose
        kotlinOptions.jvmTarget = kotlinJvmTarget
        buildFeatures.compose = true
    }
}

dependencies {
    Dependencies.run {
        api(api)
        implementation(implementations)
        testImplementation(testImplementations)
        androidTestImplementation(androidTestImplementations)
        kapt(kaptProcessors)
    }
}