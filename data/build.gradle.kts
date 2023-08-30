plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}
android {
    namespace = "com.myproject.data"
    compileSdk = 33
}

val composeVersion =
    rootProject.extra.get("compose_ui_version") as String
val navVersion = "2.5.3"
val hiltVersion = "2.45"
val googleServiceVersion = rootProject.extra.get("gms_version") as String
val firebaseBom = "32.1.0"
val firebaseAuth = "22.0.0"
val moshi = "1.15.0"

dependencies {
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
    implementation("com.squareup.moshi:moshi:$moshi")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
}
