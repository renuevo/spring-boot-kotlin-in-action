package com.github.renuevo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootServerToClientEventApplication

fun main(args: Array<String>) {
    runApplication<SpringBootServerToClientEventApplication>(*args)
}