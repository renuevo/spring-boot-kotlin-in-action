package com.github.renuevo.proxy

import com.github.renuevo.proxy.domain.cglib.CglibService
import io.kotest.core.spec.style.ShouldSpec
import mu.KotlinLogging
import org.springframework.cglib.proxy.Enhancer
import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy
import java.lang.reflect.Method

internal class CglibTest : ShouldSpec({

    context("Cglib Test") {


        should("Method Interceptor") {
            val enhancer = Enhancer()
            enhancer.setSuperclass(CglibService::class.java)
            enhancer.setCallbacks(
                arrayOf(
                    TestCglibMethodInterceptor("0"),    //0
                    TestCglibMethodInterceptor("1"),    //1
                )
            )
            enhancer.setCallbackFilter {
                if (it.name == "methodA") 1
                else 0
            }

            val proxy = enhancer.create() as CglibService

            proxy.methodA()
            proxy.methodB()
            proxy.methodC()
        }

    }

})


internal class TestCglibMethodInterceptor(private val number: String) : MethodInterceptor {

    private val log = KotlinLogging.logger { }

    override fun intercept(obj: Any, method: Method, args: Array<out Any>?, proxy: MethodProxy): Any? {

        log.info { "interceptor number is $number" }

        //성능상 이점을 가진다
        return proxy.invokeSuper(obj, (args ?: arrayOfNulls(0)))
    }

}