package com.github.renuevo.proxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootProxyApplication

fun main(args: Array<String>) {
    runApplication<SpringBootProxyApplication>(*args)
}