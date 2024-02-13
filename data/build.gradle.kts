import plugins.MainGradlePlugin

plugins {
    id("project.android.library")
}

android {
    namespace = "com.gerbort.data"
}

dependencies {

    room()

    common()
    networking()
    database()

}