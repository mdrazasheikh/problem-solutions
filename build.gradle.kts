plugins {
    kotlin("jvm") version "2.1.21"
}

group = "solutions"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    jvmToolchain(21)
}

sourceSets {
    main {
        java {
            // db/livecoding/Problem.java is a preserved code-review exercise. Two of the
            // findings recorded in it are that it does not compile, so it is kept verbatim
            // and excluded from the build. Solution.java is the fixed, compiling version.
            exclude("db/livecoding/Problem.java")
        }
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(21)
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs("--enable-preview")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
}
