package com.github.renuevo.account.outgoing

import com.github.renuevo.account.Account

interface UpdateAccountPort {
    fun updateAccount(account: Account): Account
}