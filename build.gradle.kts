buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(hiltAgp())
        classpath(kotlinAgp())
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")
    }
}

plugins {
    id("com.google.devtools.ksp") version Versions.kspPlugin apply false
}