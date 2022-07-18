package com.github.renuevo.account.incoming

import com.github.renuevo.account.Account
import com.github.renuevo.account.Money

interface CreateAccountUseCase {
    fun createAccount(createAccountCommand: CreateAccountCommand): Account
}

data class CreateAccountCommand(
    val name: String,
    val amount: Long
)

fun CreateAccountCommand.toAccount() = Account(
    id = 0,
    accountNumber = name,
    Money(amount)
)