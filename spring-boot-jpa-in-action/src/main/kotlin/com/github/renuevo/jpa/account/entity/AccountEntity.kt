package com.github.renuevo.jpa.account.entity

import com.github.renuevo.account.Account
import com.github.renuevo.account.Money
import com.github.renuevo.jpa.common.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.persistence.Table


@Entity
@Table(name = "account")
data class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String

) : BaseEntity() {

    @OneToOne(mappedBy = "account")
    var accountMoneyEntity: AccountMoneyEntity? = null
}


fun AccountEntity.toAccount() = Account(
    id = id,
    name = name,
    money = Money(amount = accountMoneyEntity!!.amount)
)