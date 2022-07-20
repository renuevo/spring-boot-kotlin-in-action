package com.github.renuevo.domain.account.outgoing

import com.github.renuevo.domain.account.Account

interface LoadAccountPort {

    fun loadAccount(id: Long): Account?

    fun loadAccountAll(): List<Account>

}