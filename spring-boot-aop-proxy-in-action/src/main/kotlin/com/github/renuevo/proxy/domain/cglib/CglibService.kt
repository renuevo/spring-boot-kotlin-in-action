package com.github.renuevo.proxy.domain.cglib

import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CglibService {

    private val log = KotlinLogging.logger { }

    fun methodA() = log.info { "I'm A" }
    fun methodB() = log.info { "I'm B" }
    fun methodC() = log.info { "I'm C" }

}