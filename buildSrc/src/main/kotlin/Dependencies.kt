object Dependencies {

    val springBootWeb by lazy { "org.springframework.boot:spring-boot-starter-web" }
    val springBootJpa by lazy { "org.springframework.boot:spring-boot-starter-data-jpa" }
    val springBootAop by lazy { "org.springframework.boot:spring-boot-starter-aop" }
    val springCloud by lazy { "org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloudVersion}" }


    val kotlinReflect by lazy { "org.jetbrains.kotlin:kotlin-reflect" }
    val kotlinStdlibJdk8 by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8" }
    val kotlinCoroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:${Versions.coroutines}" }


    val resilience4jSpringBoot by lazy { "io.github.resilience4j:resilience4j-micrometer:${Versions.resilience4jVersion}" }
    val resilience4jMicrometer by lazy { "io.github.resilience4j:resilience4j-spring-boot2:${Versions.resilience4jVersion}" }
    val springCloudOpenFeign by lazy { "org.springframework.cloud:spring-cloud-starter-openfeign:${Versions.openfeignVersion}" }
    val jacksonModule by lazy { "com.fasterxml.jackson.module:jackson-module-kotlin" }

    val h2 by lazy { "com.h2database:h2" }
    val postgres by lazy { "org.postgresql:postgresql" }
    val queryDslJpa by lazy { "com.querydsl:querydsl-jpa:${Versions.querydslVersion}" }
    val queryDslApt by lazy { "com.querydsl:querydsl-apt:${Versions.querydslVersion}:jpa" }

}


object TestDependencies {

    val springBootTest by lazy { "org.springframework.boot:spring-boot-starter-test" }
    val kotlinCoroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}" }

    val kotestSpring by lazy { "io.kotest.extensions:kotest-extensions-spring:${Versions.kotestSpring}" }
    val kotestJunit by lazy { "io.kotest:kotest-runner-junit5:${Versions.kotest}" }
    val kotestAssertions by lazy { "io.kotest:kotest-assertions-core:${Versions.kotest}" }
    val kotestProperty by lazy { "io.kotest:kotest-property:${Versions.kotest}" }

    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }

}