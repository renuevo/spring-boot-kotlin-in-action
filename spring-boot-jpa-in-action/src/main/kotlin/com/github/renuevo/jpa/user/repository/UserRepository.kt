package com.github.renuevo.jpa.user.repository

import com.github.renuevo.jpa.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByName(name: String): List<UserEntity>

}