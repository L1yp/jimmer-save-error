import org.gradle.plugins.ide.idea.model.IdeaModel
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.spring") version "1.9.21"
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
    idea
    java
}

group = "org.babyfish.jimmer"
version = "0.0.1"



val jimmerVersion = "0.9.68"

// Jimmer remote associations require ANTLR
val antlrVersion = "4.13.2"


repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {

    implementation(kotlin("stdlib"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-logging")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.aspectj:aspectjweaver")

    // Sa-Token 权限认证，在线文档：https://sa-token.cc
    implementation("org.apache.commons:commons-lang3")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.hibernate.validator:hibernate-validator:8.0.1.Final")


    ksp("org.babyfish.jimmer:jimmer-ksp:${jimmerVersion}")
    implementation("org.babyfish.jimmer:jimmer-spring-boot-starter:$jimmerVersion")
    runtimeOnly("org.antlr:antlr4-runtime:$antlrVersion")

    runtimeOnly("mysql:mysql-connector-java:8.0.30")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "21"
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

configure<IdeaModel> {
    module {
        isDownloadSources = true // 自动下载源码
        isDownloadJavadoc = true // 自动下载文档
    }
}