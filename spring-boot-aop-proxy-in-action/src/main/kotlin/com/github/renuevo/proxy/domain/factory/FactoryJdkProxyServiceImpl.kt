package com.github.renuevo.proxy.domain.factory

import mu.KotlinLogging
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class FactoryJdkProxyServiceImpl : FactoryJdkProxyService{

    private val log = KotlinLogging.logger { }

    @Async
    override fun methodA() = log.info { "I'm A" }

    @Async
    override fun methodB() = log.info { "I'm B" }

    @Async
    override fun methodC() = log.info { "I'm C" }

}