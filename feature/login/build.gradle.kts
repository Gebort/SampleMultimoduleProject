import plugins.ComposeGradlePlugin
import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()
apply<ComposeGradlePlugin>()

android {
    namespace = "com.gerbort.login"
}

dependencies {

    compose()
    testing()
    hilt()

    ui()
    common()
    preferences()
    data()

}