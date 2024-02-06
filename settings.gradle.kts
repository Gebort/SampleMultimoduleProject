pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SampleProject"
include(":app")
include(":core:ui")
include(":preferences")
include(":core:common")
include(":core:common")
include(":feature:login")
include(":networking")
include(":database")
include(":data")
include(":sync")
