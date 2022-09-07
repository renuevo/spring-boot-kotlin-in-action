package com.github.renuevo.proxy.domain.factory.config

import mu.KotlinLogging
import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation
import org.springframework.aop.support.DefaultPointcutAdvisor
import org.springframework.aop.support.NameMatchMethodPointcut
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomAdvisorConfig {

    @Bean
    fun targetPointcut() = NameMatchMethodPointcut().apply { addMethodName("proxyTarget*") }


    @Bean
    fun customAdvice() = CustomAdvice()


    @Bean
    fun customAdvisor() = DefaultPointcutAdvisor(targetPointcut(), customAdvice())

}


class CustomAdvice : MethodInterceptor {

    private val log = KotlinLogging.logger { }

    override fun invoke(invocation: MethodInvocation): Any? {

        log.info { "Proxy 부가기능" }

        return invocation.proceed()
    }
}