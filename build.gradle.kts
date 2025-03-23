plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ksp)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.kotlin.spring)
}

group = "v.boot"   //定义组
version = "0.1.0"  //定义版本

repositories {   //定义自定义仓库地址
    mavenLocal()
    mavenCentral()
}

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
    }
}


tasks.bootJar {
    archiveFileName.set("${project.rootProject.name}-${project.name}.jar")
}

tasks.jar {
    archiveClassifier.set("")  // 移除 "-plain" 后缀（classifier）
    archiveBaseName.set(project.name)  // 可选：修改基础名称（默认是项目名，如 system）
    archiveVersion.set("")      // 可选：固定版本（如果不想带版本，可以设为空）
    // 如果想完全自定义文件名（包括扩展名）
    // archiveFileName.set('my-custom-name.jar')
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.aop)
    implementation(libs.spring.boot.starter.test)
    implementation(libs.flyway.core)

    implementation(libs.jimmer.spring.boot.starter)
    ksp(libs.jimmer.ksp)

    implementation(libs.jackson.module.kotlin)
    runtimeOnly(libs.sqlite)

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}
tasks.test {
    useJUnitPlatform()
}
kotlin.compilerOptions.freeCompilerArgs.add("-Xannotation-default-target=param-property")
