package com.github.renuevo.jpa.account.entity

import com.github.renuevo.domain.account.Account
import com.github.renuevo.domain.account.Money
import com.github.renuevo.jpa.common.BaseEntity
import com.github.renuevo.jpa.user.entity.UserEntity
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne
import javax.persistence.Table


@Entity
@Table(name = "account")
class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    accountNumber: String,
    userId: Long

) : BaseEntity() {

    var accountNumber: String = accountNumber
        protected set

    var userId: Long = userId
        protected set

    @OneToOne(mappedBy = "account")
    var accountMoneyEntity: AccountMoneyEntity? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_entity_id", insertable = false, updatable = false)
    var user: UserEntity? = null
}


fun AccountEntity.toAccount() = Account(
    id = id,
    accountNumber = accountNumber,
    money = Money(amount = accountMoneyEntity!!.amount)
)

fun Account.toEntity(userId: Long) = AccountEntity(
    id = id,
    accountNumber = accountNumber,
    userId = userId
)