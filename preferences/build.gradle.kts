import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.gerbort.preferences"
}

dependencies {

    hilt()
    common()
    datastore()

}