package com.github.renuevo.domain.user.outgoing

import com.github.renuevo.domain.account.Account

interface LoadUserAccountInfoPort {

    fun findByUserAccount(userId: Long): List<Account>

}