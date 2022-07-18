package com.github.renuevo.user.outgoing

import com.github.renuevo.user.User

interface LoadUserPort {

    fun findById(id: Long): User?

    fun findByName(name: String): List<User>

    fun findUserAll(): List<User>

}