package com.github.renuevo.jpa.account.repository

import com.github.renuevo.jpa.account.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<AccountEntity, Long> {
}