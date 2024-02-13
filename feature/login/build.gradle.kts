import plugins.ComposeGradlePlugin
import plugins.MainGradlePlugin

plugins {
    id("project.android.library")
    id("project.android.library.compose")
}

android {
    namespace = "com.gerbort.login"
}

dependencies {

    ui()
    common()
    preferences()
    data()

}