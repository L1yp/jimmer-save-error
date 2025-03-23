package com.babyfish.jimmer

import org.babyfish.jimmer.client.EnableImplicitApi
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableImplicitApi
@SpringBootApplication
class JimmerSaveErrorApplication

fun main(args: Array<String>) {
    runApplication<JimmerSaveErrorApplication>(*args)
}