package com.github.renuevo.domain.account.outgoing

import com.github.renuevo.domain.account.Account

interface CreateAccountPort {
    fun createAccount(account: Account, userId: Long): Account
}