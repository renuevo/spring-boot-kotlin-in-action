package com.github.renuevo.jpa.account.adapter

import com.github.renuevo.domain.account.Account
import com.github.renuevo.domain.account.outgoing.CreateAccountPort
import com.github.renuevo.jpa.account.entity.toAccount
import com.github.renuevo.jpa.account.entity.toEntity
import com.github.renuevo.jpa.account.repository.AccountRepository

class CreateAccountAdapter(private val accountRepository: AccountRepository) : CreateAccountPort {

    override fun createAccount(account: Account, userId: Long): Account = accountRepository.save(account.toEntity(userId)).toAccount()

}