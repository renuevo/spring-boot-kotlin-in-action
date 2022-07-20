package com.github.renuevo.domain

import com.github.renuevo.domain.account.Account
import com.github.renuevo.domain.account.Money

object AccountFixtures {

    const val ACCOUNT_ID: Long = 1

    fun `account object`(
        id: Long = ACCOUNT_ID,
        accountNumber: String = "010-111-3333",
        money: Money = `money object`()
    ) = Account(id = id, accountNumber = accountNumber, money = money)


    fun `money object`(
        amount: Long = 100
    ) = Money(amount = amount)
}