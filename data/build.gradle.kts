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
