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