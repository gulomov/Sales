import libs.AccompanistPager.accompanistPager
import libs.AndroidCode.androidCore
import libs.Coil.coil
import libs.Compose.compose
import libs.ComposeUi.composeUi
import libs.Firebase.firebase
import libs.Hilt.hilt
import libs.Moshi.moshi
import libs.Timber.timber

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("io.gitlab.arturbosch.detekt")
}

val composeVersion =
    rootProject.extra.get("compose_ui_version") as String
val navVersion = "2.5.3"
val hiltVersion = "2.45"
val googleServiceVersion = rootProject.extra.get("gms_version") as String
val firebaseBom = "32.1.0"
val firebaseAuth = "22.0.0"
val moshi = "1.15.0"

android {
    namespace = "com.myproject.sales"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.myproject.sales"
        minSdk = 24
        targetSdk = 33
        versionCode = 2
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        debug {
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-android-optimize.txt",
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    flavorDimensions.add("version")
    productFlavors {
        create("free") {
            dimension = "version"
        }
        create("premium") {
            dimension = "version"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }

    detekt {
        toolVersion = "1.23.1"
        config.setFrom(file("config/detekt.yml"))
    }
}

dependencies {

    implementation(project(":data"))

    androidCore()
    accompanistPager()
    coil()
    compose()
    composeUi()
    firebase()
    hilt()
    moshi()
    timber()
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
