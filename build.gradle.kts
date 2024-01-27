buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(hiltAgp())
        classpath(kotlinAgp())
    }
}

plugins {
    id("com.google.devtools.ksp") version Versions.kspPlugin apply false
    id("com.android.library") version Versions.android apply false
    id("org.jetbrains.kotlin.android") version Versions.kotlin apply false
}