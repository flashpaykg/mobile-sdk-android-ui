plugins {
    id("convention.android.app")
    id("signing")
}

android {
    namespace = "kg.flashpay.ui.msdk.sample"
    defaultConfig {
        applicationId = "kg.flashpay.ui.msdk.sample"
        versionName = System.getenv("SDK_VERSION_NAME") ?: Library.version
        versionCode = System.getenv("SDK_VERSION_CODE")?.toInt() ?: 1
    }
}

dependencies {
    implementation(project(":mobile-sdk-android-ui-flashpay"))
    implementation(project(":mobile-sdk-android-ui"))
}
