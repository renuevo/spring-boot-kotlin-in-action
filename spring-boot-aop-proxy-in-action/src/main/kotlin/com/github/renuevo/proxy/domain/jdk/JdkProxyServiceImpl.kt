package com.github.renuevo.proxy.domain.jdk

import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class JdkProxyServiceImpl : JdkProxyService {

    private val log = KotlinLogging.logger { }

    override fun methodA() = log.info { "I'm A" }
    override fun methodB() = log.info { "I'm B" }
    override fun methodC() = log.info { "I'm C" }

}