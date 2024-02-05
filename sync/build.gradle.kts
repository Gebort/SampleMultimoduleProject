import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.gerbort.sync"
}

dependencies {

    testing()
    hilt()
    workManager()

    common()
    data()
}