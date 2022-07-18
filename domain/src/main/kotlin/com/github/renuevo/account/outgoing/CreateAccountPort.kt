package com.github.renuevo.account.outgoing

import com.github.renuevo.account.Account

interface CreateAccountPort {
    fun createAccount(account: Account): Account
}