package com.github.renuevo.proxy

import com.github.renuevo.proxy.domain.jdk.JdkProxyService
import com.github.renuevo.proxy.domain.jdk.JdkProxyServiceImpl
import io.kotest.core.spec.style.ShouldSpec
import mu.KotlinLogging
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

internal class JdkProxyTest : ShouldSpec({

    context("JDK Proxy Test") {


        should("Invocation Handler") {

            val jdkProxyTarget: JdkProxyService = JdkProxyServiceImpl()

            val proxy = Proxy.newProxyInstance(
                jdkProxyTarget::class.java.classLoader,
                arrayOf(JdkProxyService::class.java),
                TestInvocationHandler(jdkProxyTarget)
            ) as JdkProxyService

            proxy.methodA()
            proxy.methodB()
            proxy.methodC()
        }

    }

})


internal class TestInvocationHandler(private val target: JdkProxyService) : InvocationHandler {

    private val log = KotlinLogging.logger { }

    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {

        when (method.name) {
            "methodA" -> log.info { "너는 A로 향하는군" }
            else -> log.info { "TestInvocationHandler 지나갑니다" }
        }

        return method.invoke(target, *(args ?: arrayOfNulls(0)))    //실제 target 호출
    }

}