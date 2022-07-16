package com.github.renuevo.account.outgoing

import com.github.renuevo.account.Account

interface LoadAccountPort {

    fun loadAccount(id: Long): Account?

    fun loadAccountAll(): List<Account>

}