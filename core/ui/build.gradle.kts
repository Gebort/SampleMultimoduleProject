import plugins.ComposeGradlePlugin
import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()
apply<ComposeGradlePlugin>()

android {
    namespace = "com.core.core_ui"
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    testing()
    hilt()
    compose()
}