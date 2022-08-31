package com.github.renuevo.jpa.user.repository

import com.github.renuevo.jpa.user.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.history.RevisionRepository

interface UserRepository : JpaRepository<UserEntity, Long>, RevisionRepository<UserEntity, Long, Int> {

    fun findByName(name: String): List<UserEntity>

}