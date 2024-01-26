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
//    id("com.android.library") version "8.2.1" apply true
  //  id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}