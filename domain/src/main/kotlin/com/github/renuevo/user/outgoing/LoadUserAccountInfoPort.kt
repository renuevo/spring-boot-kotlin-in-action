package com.github.renuevo.user.outgoing

import com.github.renuevo.account.Account

interface LoadUserAccountInfoPort {

    fun findByUserAccount(userId: Long): List<Account>

}