plugins {
    kotlin("jvm") version "2.3.20"
}

val adventureKtPlatform = providers.gradleProperty("adventureKtPlatform").getOrElse("paper")
val adventureVersion = when (adventureKtPlatform) {
    "paper" -> "5.1.1"
    "velocity" -> "4.26.1"
    else -> error("Unsupported adventureKtPlatform: $adventureKtPlatform")
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")

    group = "plutoproject.adventurekt"
    version = "v3.0.0-$adventureKtPlatform"

    repositories {
        mavenCentral()
        maven {
            name = "papermc"
            url = uri("https://repo.papermc.io/repository/maven-public/")
        }
    }

    dependencies {
        api("net.kyori:adventure-api:$adventureVersion")
        api("net.kyori:adventure-text-minimessage:$adventureVersion")
        api("net.kyori:adventure-text-serializer-gson:$adventureVersion")
        api("net.kyori:adventure-text-serializer-legacy:$adventureVersion")
        api("net.kyori:adventure-text-serializer-plain:$adventureVersion")
        api("net.kyori:adventure-text-serializer-ansi:$adventureVersion")
    }

    tasks.withType<Test>().configureEach {
        failOnNoDiscoveredTests = false
    }
}
