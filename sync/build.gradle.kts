import plugins.MainGradlePlugin

plugins {
    id("project.android.library")
}

android {
    namespace = "com.gerbort.sync"
}

dependencies {

    workManager()

    common()
    data()
}