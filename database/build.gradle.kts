import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
    id("com.google.devtools.ksp")
}

apply<MainGradlePlugin>()

android {
    namespace = "com.gerbort.database"

    defaultConfig {
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }
    }
}

dependencies {

    testing()
    room()
    hilt()

    common()

}