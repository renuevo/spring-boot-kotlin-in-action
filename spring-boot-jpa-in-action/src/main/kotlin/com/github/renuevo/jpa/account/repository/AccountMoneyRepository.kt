package com.github.renuevo.jpa.account.repository

import com.github.renuevo.jpa.account.entity.AccountMoneyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountMoneyRepository : JpaRepository<AccountMoneyEntity, Long> {
}