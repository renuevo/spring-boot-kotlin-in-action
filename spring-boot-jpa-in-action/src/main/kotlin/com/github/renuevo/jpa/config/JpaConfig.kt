package com.github.renuevo.jpa.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.github.renuevo.jpa"],
    repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean::class
)
class JpaConfig