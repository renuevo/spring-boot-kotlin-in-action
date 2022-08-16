package com.github.renuevo.proxy.domain.factory

import mu.KotlinLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class FactoryCglibService {

    private val log = KotlinLogging.logger { }


    @Async
    fun methodA() = log.info { "I'm A" }

    @Async
    fun methodB() = log.info { "I'm B" }

    @Async
    fun methodC() = log.info { "I'm C" }

}