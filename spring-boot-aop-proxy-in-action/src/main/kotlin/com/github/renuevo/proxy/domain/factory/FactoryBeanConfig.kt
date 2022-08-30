package com.github.renuevo.proxy.domain.factory

import com.github.renuevo.proxy.domain.jdk.JdkProxyService
import com.github.renuevo.proxy.domain.jdk.JdkProxyServiceImpl
import mu.KotlinLogging
import org.springframework.beans.factory.FactoryBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

@Configuration
class FactoryBeanConfig {

    @Bean
    fun jdkProxyService(): TestFactoryBean {
        return TestFactoryBean(
            interfaceType = JdkProxyService::class.java,
            target = JdkProxyServiceImpl()
        )
    }

}

class TestFactoryBean(
    private val interfaceType: Class<*>,
    private val target: Any
) : FactoryBean<Any> {

    override fun getObject(): Any = Proxy.newProxyInstance(
        interfaceType.classLoader,
        arrayOf(interfaceType),
        FactoryBeanInvocationHandler(target)
    )

    override fun getObjectType(): Class<*> = interfaceType

}


class FactoryBeanInvocationHandler(private val target: Any) : InvocationHandler {

    private val log = KotlinLogging.logger { }

    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {

        log.info { "Factory Bean Invocation Handler" }

        return method.invoke(target, *(args ?: arrayOfNulls(0)))    //실제 target 호출
    }

}