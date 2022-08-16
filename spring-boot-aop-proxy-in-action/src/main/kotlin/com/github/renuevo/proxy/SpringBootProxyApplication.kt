package com.github.renuevo.proxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class SpringBootProxyApplication

fun main(args: Array<String>) {
    runApplication<SpringBootProxyApplication>(*args)
}