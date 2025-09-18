import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"

    /**
     * detekt
     *
     * URL
     * - https://github.com/detekt/detekt
     * GradlePlugins(plugins.gradle.org)
     * - https://plugins.gradle.org/plugin/io.gitlab.arturbosch.detekt
     * Main用途
     * - Linter/Formatter
     * Sub用途
     * - 無し
     * 概要
     * KotlinのLinter/Formatter
     */
    id("io.gitlab.arturbosch.detekt") version "1.23.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    /**
     * Database Rider
     *
     * - Rider Core
     * - Rider Spring
     * - Rider JUnit 5
     *
     * URL
     * - https://database-rider.github.io/database-rider/
     * MavenCentral
     * - https://mvnrepository.com/artifact/com.github.database-rider/rider-core
     * - https://mvnrepository.com/artifact/com.github.database-rider/rider-spring
     * - https://mvnrepository.com/artifact/com.github.database-rider/rider-junit5
     * Main用途
     * - JUnitでDB周りのテスト時のヘルパー
     * 概要
     * - テーブルの事前条件、事後条件を簡潔に設定できる
     */
    implementation("com.github.database-rider:rider-core:1.44.0")
    implementation("com.github.database-rider:rider-spring:1.44.0")
    testImplementation("com.github.database-rider:rider-junit5:1.44.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
