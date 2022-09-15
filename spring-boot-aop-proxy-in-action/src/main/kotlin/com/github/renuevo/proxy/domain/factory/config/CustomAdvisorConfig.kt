package com.github.renuevo.proxy.domain.factory.config

import com.github.renuevo.proxy.domain.factory.FactoryCglibService
import mu.KotlinLogging
import org.aopalliance.aop.Advice
import org.aopalliance.intercept.MethodInterceptor
import org.aopalliance.intercept.MethodInvocation
import org.springframework.aop.Advisor
import org.springframework.aop.Pointcut
import org.springframework.aop.framework.ProxyFactoryBean
import org.springframework.aop.support.DefaultPointcutAdvisor
import org.springframework.aop.support.NameMatchMethodPointcut
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CustomAdvisorConfig {

    @Bean
    fun targetPointcut(): Pointcut = NameMatchMethodPointcut().apply { addMethodName("method*") }


    @Bean
    fun customAdvice(): Advice = CustomAdvice()


    @Bean
    fun customAdvisor(): Advisor = DefaultPointcutAdvisor(targetPointcut(), customAdvice())


    @Bean
    fun proxyFactoryBean() = ProxyFactoryBean().apply {
        setTarget(ProxyFactoryBeanTarget())
        setInterceptorNames("customAdvisor")
    }

}

class ProxyFactoryBeanTarget : FactoryCglibService()


class CustomAdvice : MethodInterceptor {

    private val log = KotlinLogging.logger { }

    override fun invoke(invocation: MethodInvocation): Any? {

        log.info { "Proxy 부가기능" }

        return invocation.proceed()
    }
}