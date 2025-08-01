import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("convention.android.library")
    id("com.vanniktech.maven.publish")
    id("signing")
}

group = Library.group
version = Library.version

mavenPublishing {
    coordinates(
        group.toString(),
        "${Library.artifactId}-common",
        version.toString()
    )

    pom {
        name.set("mSDK UI Module Common")
        description.set("SDK for Android is a software development kit for fast integration of payment solutions right in your mobile application for Android.")
        url.set("https://github.com/flashpaykg/mobile-sdk-android-ui")
        licenses {
            license {
                name.set("MIT")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("<id>")
                name.set("<name>")
                url.set("<url>")
            }
        }
        scm {
            url.set("https://github.com/flashpaykg/mobile-sdk-android-ui")
        }
    }

    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = true,
            publishJavadocJar = true,
        )
    )

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}

android {
    namespace = "kg.paymentpage.msdk.ui"
    buildTypes {
        release {
            buildConfigField(
                "Boolean",
                "IS_TIME_TRAVEL",
                "false"
            )
        }
        debug {
            buildConfigField(
                "Boolean",
                "IS_TIME_TRAVEL",
                "true"
            )
        }
    }
    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }
}

dependencies {
    implementation(LibraryDependencies.Msdk.core)
    implementation ("com.jakewharton.threetenabp:threetenabp:1.4.0")
}