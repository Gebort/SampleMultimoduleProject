import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.gerbort.data"
}

dependencies {

    testing()
    hilt()
    room()

    common()
    networking()
    database()

}