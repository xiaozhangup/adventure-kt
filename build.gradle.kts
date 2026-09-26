plugins {
    kotlin("jvm") version "2.3.20"
}

val adventureVersion = "5.2.0"

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "java")

    group = "plutoproject.adventurekt"
    version = "v3.0.0"

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
