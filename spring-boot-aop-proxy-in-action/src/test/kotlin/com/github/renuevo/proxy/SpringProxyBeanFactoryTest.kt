package com.github.renuevo.proxy

import com.github.renuevo.proxy.domain.factory.FactoryCglibService
import com.github.renuevo.proxy.domain.factory.FactoryJdkProxyService
import com.github.renuevo.proxy.domain.factory.FactoryJdkProxyServiceImpl
import com.github.renuevo.proxy.domain.factory.config.ProxyFactoryBeanTarget
import io.kotest.core.spec.style.ShouldSpec
import mu.KotlinLogging
import org.springframework.aop.Advisor
import org.springframework.aop.framework.ProxyFactory
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class SpringProxyBeanFactoryTest(
    private val factoryJdkProxyService: FactoryJdkProxyService,
    private val factoryCglibService: FactoryCglibService,
    private val proxyFactoryBean: ProxyFactoryBeanTarget,
    private val customAdvisor: Advisor
) : ShouldSpec({

    val log = KotlinLogging.logger { }


    context("Proxy Bean Factory Test") {

        should("Factory Proxy Test") {
            log.info { factoryJdkProxyService.javaClass.toString() }
            log.info { factoryCglibService.javaClass.toString() }
            log.info { proxyFactoryBean.javaClass.toString() }
        }

        should("Call Proxy Bean Factory Method") {
            proxyFactoryBean.methodA()
            proxyFactoryBean.methodB()
            proxyFactoryBean.methodC()
        }


        should("JDK Proxy Factory Test") {
            val proxy = ProxyFactory(FactoryJdkProxyServiceImpl()).apply {
                addAdvisor(customAdvisor)
            }.proxy as FactoryJdkProxyService

            log.info { proxy.javaClass.toString() }

            proxy.methodA()
            proxy.methodB()
            proxy.methodC()
        }

        should("CGlib Proxy Factory Test") {
            val proxy = ProxyFactory(ProxyFactoryBeanTarget()).apply {
                isProxyTargetClass = true
                addAdvisor(customAdvisor)
            }.proxy as ProxyFactoryBeanTarget

            log.info { proxy.javaClass.toString() }

            proxy.methodA()
            proxy.methodB()
            proxy.methodC()
        }

        should("Interface Target To CGLIB Proxy Test") {
            val proxy = ProxyFactory(FactoryJdkProxyServiceImpl()).apply {
                isProxyTargetClass = true
                addAdvisor(customAdvisor)
            }.proxy as FactoryJdkProxyService

            log.info { proxy.javaClass.toString() }

            proxy.methodA()
            proxy.methodB()
            proxy.methodC()
        }

    }

})