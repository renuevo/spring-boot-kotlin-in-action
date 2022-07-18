package com.github.renuevo.account.incoming

import com.github.renuevo.account.Account

interface LoadAccountQuery {
    fun findById(id: Long): Account?

    fun findByName(name: String): Account?

    fun findByAll(): List<Account>
}