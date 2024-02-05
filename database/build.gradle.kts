import plugins.MainGradlePlugin

plugins {
    `android-library`
    `kotlin-android`
}

apply<MainGradlePlugin>()

android {
    namespace = "com.gerbort.database"

    defaultConfig {
//        ksp {
//            arg("room.schemaLocation", "$projectDir/schemas")
//        }
    }
}

android {
    namespace = "com.gerbort.database"



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    testing()
    room()
    hilt()

    common()

}