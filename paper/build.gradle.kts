dependencies {
    implementation(libs.corn.paper)
    implementation(libs.cloud.paper)

    api(projects.ringCore)

    compileOnlyApi(libs.adventure.api)
    compileOnlyApi(libs.paper.api) {
        exclude(module = "guava")
        exclude(module = "gson")
        exclude(module = "snakeyaml")
        exclude(module = "commons-lang")
    }
}

tasks {

    build {
        dependsOn(named("shadowJar"))
    }

    shadowJar {
        fun relocates(vararg dependencies: String) {
            dependencies.forEach {
                val split = it.split('.')
                val name = split.last()
                relocate(it, "${rootProject.group}.dependencies.$name")
            }
        }

        dependencies {
            exclude(dependency("com.google.guava:"))
            exclude(dependency("com.google.errorprone:"))
            exclude(dependency("org.checkerframework:"))
            exclude(dependency("org.jetbrains:"))
            exclude(dependency("org.intellij:"))
        }

        relocates(
            "org.slf4j",
            "org.jdbi",
            "io.papermc.lib",
            "cloud.commandframework",
            "net.kyori",
            "broccolai.corn",
            "org.spongepowered",
            "com.google.inject",
            "com.google.j2objc",
        )

        archiveClassifier.set(null as String?)
        archiveFileName.set(project.name + ".jar")
        destinationDirectory.set(rootProject.tasks.shadowJar.get().destinationDirectory.get())
    }
}