package com.github.renuevo.proxy

import com.github.renuevo.proxy.domain.factory.FactoryCglibService
import com.github.renuevo.proxy.domain.factory.FactoryJdkProxyService
import io.kotest.core.spec.style.ShouldSpec
import mu.KotlinLogging
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class SpringProxyBeanFactoryTest(
    private val factoryJdkProxyService: FactoryJdkProxyService,
    private val factoryCglibService: FactoryCglibService
) : ShouldSpec({

    val log = KotlinLogging.logger { }

    should("Factory Proxy Test") {
        log.info { factoryJdkProxyService.javaClass.toString() }
        log.info { factoryCglibService.javaClass.toString() }
    }

})