package com.github.renuevo.proxy

import com.github.renuevo.proxy.domain.factory.FactoryCglibService
import com.github.renuevo.proxy.domain.factory.FactoryJdkProxyService
import io.kotest.core.spec.style.ShouldSpec
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class SpringBeanFactoryTest(
    private val factoryJdkProxyService: FactoryJdkProxyService,
    private val factoryCglibService: FactoryCglibService
) : ShouldSpec({

    should("Factory Proxy Test"){
        println(factoryJdkProxyService.javaClass)
        println(factoryCglibService.javaClass)
    }

})