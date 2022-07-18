package com.github.renuevo.account.incoming

interface SendMoneyUseCase {
    fun sendAccountMoney(sendAccountMoneyCommand: SendAccountMoneyCommand): Boolean

}

data class SendAccountMoneyCommand(
    val accountId: Long,
    val receiveAccountId: Long,
    val amount: Long
)