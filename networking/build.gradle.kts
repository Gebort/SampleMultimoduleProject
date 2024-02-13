import plugins.MainGradlePlugin

plugins {
    id("project.android.library")
}

android {
    namespace = "com.gerbort.networking"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    retrofit()

    common()
}