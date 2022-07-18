package com.github.renuevo.jpa.user.adapter

import com.github.renuevo.jpa.user.entity.toUser
import com.github.renuevo.jpa.user.repository.UserRepository
import com.github.renuevo.user.User
import com.github.renuevo.user.outgoing.LoadUserPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class LoadUserAdapter(private val userRepository: UserRepository) : LoadUserPort {

    override fun findById(id: Long): User? = userRepository.findByIdOrNull(id)?.toUser()

    override fun findByName(name: String): List<User> = userRepository.findByName(name).map { it.toUser() }

    override fun findUserAll(): List<User> = userRepository.findAll().map { it.toUser() }
}