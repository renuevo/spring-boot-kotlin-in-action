package com.github.renuevo.jpa.account.adapter

import com.github.renuevo.account.Account
import com.github.renuevo.account.outgoing.LoadAccountPort
import com.github.renuevo.jpa.account.entity.toAccount
import com.github.renuevo.jpa.account.repository.AccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class LoadAccountAdapter(
    private val accountRepository: AccountRepository
) : LoadAccountPort {

    override fun loadAccount(id: Long): Account? = accountRepository.findByIdOrNull(id)?.toAccount()

    override fun loadAccountAll(): List<Account> = accountRepository.findAll().map { it.toAccount() }
}