import plugins.MainGradlePlugin

plugins {
    id("project.android.library")
}

android {
    namespace = "com.gerbort.preferences"
}

dependencies {

    common()
    datastore()

}