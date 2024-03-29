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

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.compose.material:material:1.2.0")
    implementation("androidx.navigation:navigation-compose:$navVersion")
    implementation(platform("com.google.firebase:firebase-bom:$firebaseBom"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-database-ktx")
    implementation("com.google.firebase:firebase-auth-ktx:$firebaseAuth")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("com.google.accompanist:accompanist-pager:0.22.0-rc")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("com.squareup.moshi:moshi:$moshi")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    detektPlugins("ru.kode:detekt-rules-compose:1.3.0")
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
