plugins {
    kotlin("jvm") version "2.1.21"
}

group = "solutions"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDirs("src/java")
        kotlin.srcDirs("src/kotlin")
    }
}

kotlin {
    jvmToolchain(21)
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(21)
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-preview")
}
