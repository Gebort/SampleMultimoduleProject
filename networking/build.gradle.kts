import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.gerbort.networking"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    testing()
    hilt()
    retrofit()

    common()
}