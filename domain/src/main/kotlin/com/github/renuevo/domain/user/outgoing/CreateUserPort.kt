package com.github.renuevo.domain.user.outgoing

import com.github.renuevo.domain.user.User

interface CreateUserPort {

    fun createUser(user: User): User

}