@file:Suppress("unused")

object Library {
    const val artifactId = "msdk-ui"
    const val version = "3.8.8"
    const val group = "kg.flashpay"
}

object Versions {
    const val compose = "1.7.4"
    const val serialization = "1.3.3"
    const val detekt = "1.20.0"
    const val msdkCore = "0.12.6"
}

object LibraryDependencies {
    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val icons = "androidx.compose.material:material-icons-core:${Versions.compose}"
        const val animationCore = "androidx.compose.animation:animation:${Versions.compose}"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val runtimeLiveData = "androidx.compose.runtime:runtime:${Versions.compose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val navigation = "androidx.navigation:navigation-compose:2.5.3"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.1"
        const val activity = "androidx.activity:activity-compose:1.7.0"
    }

    object Accompanist {
        const val navigation = "com.google.accompanist:accompanist-navigation-animation:0.32.0"
        const val permissions = "com.google.accompanist:accompanist-permissions:0.32.0"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.6.0"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val customView = "androidx.customview:customview:1.2.0-alpha01"
        const val customViewPoolingContainer =
            "androidx.customview:customview-poolingcontainer:1.0.0-rc01"
        const val coreKtx = "androidx.core:core-ktx:1.8.0"
        const val activityKtx = "androidx.activity:activity-ktx:1.6.0-alpha05"
    }

    object KotlinX {
        const val serialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.serialization}"
    }

    object Coil {
        const val compose = "io.coil-kt:coil-compose:2.0.0-rc03"
    }

    object Google {
        const val wallet = "com.google.android.gms:play-services-wallet:19.1.0"
        const val material = "com.google.android.material:material:1.6.1"
        const val payButton = "com.google.pay.button:compose-pay-button:1.1.0"
    }

    object Msdk {
        const val core = "com.ecommpay:msdk-core-android:${Versions.msdkCore}"
    }

    object MsdkSample {
        const val colorPicker = "io.github.vanpra.compose-material-dialogs:color:0.8.1-rc"
    }
}