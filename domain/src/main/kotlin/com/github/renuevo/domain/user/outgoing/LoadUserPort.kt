package com.github.renuevo.domain.user.outgoing

import com.github.renuevo.domain.user.User

interface LoadUserPort {

    fun findById(id: Long): User?

    fun findByName(name: String): List<User>

    fun findUserAll(): List<User>

}