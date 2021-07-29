import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import net.kyori.indra.IndraCheckstylePlugin
import net.kyori.indra.IndraPlugin
import net.kyori.indra.IndraPublishingPlugin
import net.kyori.indra.repository.sonatypeSnapshots

plugins {
    id("net.kyori.indra")
    id("net.kyori.indra.publishing") apply false

    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.github.ben-manes.versions") version "0.38.0"

    // Auto-generates project files.
    idea
}

group = "dev.kscott.ring"
version = "1.0.0"
description = "A set of utilities for kscott games."

subprojects {
    apply<ShadowPlugin>()
    apply<IndraPlugin>()
    apply<IndraPublishingPlugin>()

    repositories {
        mavenCentral()
        sonatypeSnapshots()
        maven("https://papermc.io/repo/repository/maven-public/")
        maven("https://repo.broccol.ai/snapshots")
    }

    dependencies {
        compileOnly(rootProject.libs.checker.qual)
    }

    tasks {

        indra {

            javaVersions {
                target(16)
            }

            configurePublications {
                pom {
                    developers {
                        developer {
                            id.set("kadenscott")
                            email.set("kscottdev@gmail.com")
                        }
                    }
                }
            }
        }

        processResources {
            expand("version" to rootProject.version)
        }

    }

}