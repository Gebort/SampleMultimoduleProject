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