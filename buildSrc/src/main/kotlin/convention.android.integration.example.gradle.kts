plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("org.jetbrains.kotlin.plugin.serialization")
}

android {
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        signingConfig = signingConfigs.getByName("debug")

        buildConfigField(
            "String",
            "API_HOST",
            "\"${project.findProperty("API_HOST")}\""
        )

        buildConfigField(
            "String",
            "WS_API_HOST",
            "\"${project.findProperty("SOCKET_HOST")}\""
        )
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    //AndroidX
    implementation(LibraryDependencies.AndroidX.coreKtx)

    //Compose
    implementation(LibraryDependencies.Compose.ui)
    implementation(LibraryDependencies.Compose.material)
    implementation(LibraryDependencies.Compose.activity)

    //Serialization
    implementation(LibraryDependencies.KotlinX.serialization)

    //Google
    implementation(LibraryDependencies.Google.material)
    implementation(LibraryDependencies.Google.payButton)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
        freeCompilerArgs += "-Xjvm-default=all"
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}