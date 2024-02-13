import plugins.MainGradlePlugin

plugins {
    id("project.android.library")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.gerbort.database"

    defaultConfig {
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {

    room()

    common()

}