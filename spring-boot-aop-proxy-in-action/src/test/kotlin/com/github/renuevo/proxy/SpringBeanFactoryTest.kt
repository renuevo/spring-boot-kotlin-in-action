package com.github.renuevo.proxy

import com.github.renuevo.proxy.domain.factory.FactoryBeanConfig
import com.github.renuevo.proxy.domain.jdk.JdkProxyService
import io.kotest.core.extensions.Extension
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [FactoryBeanConfig::class])
internal class SpringBeanFactoryTest(
    private val jdkProxyService: JdkProxyService
) : ShouldSpec() {
    override fun extensions(): List<Extension> = listOf(SpringExtension)

    init {
        should("Factory Proxy Test") {
            jdkProxyService.methodA()
            jdkProxyService.methodB()
            jdkProxyService.methodC()
        }
    }
}