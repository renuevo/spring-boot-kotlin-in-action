package com.github.renuevo.user.outgoing

import com.github.renuevo.user.User

interface CreateUserPort {

    fun createUser(user: User): User

}