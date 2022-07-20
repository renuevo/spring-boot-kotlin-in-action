package com.github.renuevo.domain.account.outgoing

import com.github.renuevo.domain.account.Account

interface UpdateAccountPort {
    fun updateAccount(account: Account): Account
}