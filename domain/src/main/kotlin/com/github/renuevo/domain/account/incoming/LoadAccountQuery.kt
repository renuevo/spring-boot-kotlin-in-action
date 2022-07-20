package com.github.renuevo.domain.account.incoming

import com.github.renuevo.domain.account.Account

interface LoadAccountQuery {
    fun findById(id: Long): Account?

    fun findByName(name: String): Account?

    fun findByAll(): List<Account>
}