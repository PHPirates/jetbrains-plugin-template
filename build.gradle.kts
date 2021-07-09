plugins {
    id("org.jetbrains.intellij") version "1.1.2"
    kotlin("jvm") version("1.4.30-M1")

    // Plugin which can check for Gradle dependencies, use the help/dependencyUpdates task.
    id("com.github.ben-manes.versions") version "0.39.0"

    // Plugin which can update Gradle dependencies, use the help/useLatestVersions task.
    id("se.patrikerdes.use-latest-versions") version "0.2.17"

    // Test coverage
    jacoco
}

group = "com.example"
version = "0.1"

repositories {
    mavenCentral()
}

// Java target version
java.sourceCompatibility = JavaVersion.VERSION_11

sourceSets {
    getByName("main").apply {
        java.srcDirs("src", "gen")
        resources.srcDirs("resources")
    }

    getByName("test").apply {
        java.srcDirs("test")
        resources.srcDirs("test/resources")
    }
}


// Java target version
java.sourceCompatibility = JavaVersion.VERSION_11

// Specify the right jvm target for Kotlin
tasks.compileKotlin {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = JavaVersion.VERSION_11.toString()

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
}

// Same for Kotlin tests
tasks.compileTestKotlin {
    sourceCompatibility = JavaVersion.VERSION_11.toString()
    targetCompatibility = JavaVersion.VERSION_11.toString()

    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
        useIR = true
    }
}

dependencies {
    // Test dependencies

    // Also implementation junit 4, just in case
    testImplementation("junit:junit:4.13.2")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.8.0-M1")

    // Use junit 5 for test cases
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.0-M1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.0-M1")

    // Enable use of the JUnitPlatform Runner within the IDE
    testImplementation("org.junit.platform:junit-platform-runner:1.8.0-M1")

    // just in case
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime")

}

tasks.test {
    // Always run tests, even when nothing changed
    dependsOn("cleanTest")

    // Enable JUnit 5 (Gradle 4.6+).
    useJUnitPlatform()

    // Show test results
    testLogging {
        events(org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED, org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED)
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

intellij {
    // Use the since build number from plugin.xml
    updateSinceUntilBuild.set(false)

    // Keep an open until build, to avoid automatic downgrades to very old versions of the plugin
    sameSinceUntilBuild.set(true)

    // Comment out to use the latest EAP snapshot
    version.set("2021.1.3")
}
