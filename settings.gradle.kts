plugins {
    id("ca.stellardrift.polyglot-version-catalogs") version "5.0.0"
}

rootProject.name = "ring"

projectNames("core", "paper")

fun projectNames(vararg names: String) {
    include(*names)

    names.forEach {
        project(":$it").name = "ring-$it"
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")