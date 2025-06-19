pluginManagement {
    repositories {
        gradlePluginPortal()   // ogólne pluginy z plugin portal
        google()               // plugin Androida jest w Google Maven
        mavenCentral()         // czasem potrzebne dla dodatkowych pluginów
    }
    plugins {
        // Rejestrujemy wersje pluginów, których użyjemy w module app:
        id("com.android.application") version "7.4.2"
        id("com.android.library")     version "7.4.2"    // jeśli będziesz mieć biblioteki
        id("org.jetbrains.kotlin.android") version "1.9.20"
        // oraz Foojay resolver, jeśli go używasz:
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "mobileQuizApp"
include(":app")

