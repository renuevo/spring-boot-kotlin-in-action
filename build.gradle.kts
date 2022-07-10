import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version Versions.springBoot apply false
    id("io.spring.dependency-management") version Versions.springDependencyManagement apply false
    id("org.jlleitschuh.gradle.ktlint") version Versions.ktlint
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.spring") version Versions.kotlin
}

allprojects {
    repositories {
        mavenCentral()
    }

    group = "com.github"
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

subprojects {

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "kotlin-spring")
    apply(plugin = "kotlin-allopen")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java.sourceCompatibility = JavaVersion.VERSION_11
    java.targetCompatibility = JavaVersion.VERSION_11

    dependencies {

        implementation(Dependencies.jacksonModule)
        implementation(Dependencies.kotlinReflect)
        implementation(Dependencies.kotlinStdlibJdk8)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
        systemProperty("spring.profiles.active", "test")
    }

    tasks.named<Jar>("jar") {
        enabled = true
    }

    tasks.named<BootJar>("bootJar") {
        enabled = false
    }
}