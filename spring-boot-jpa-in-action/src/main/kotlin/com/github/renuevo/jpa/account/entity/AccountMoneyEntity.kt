package com.github.renuevo.jpa.account.entity

import com.github.renuevo.jpa.common.BaseEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "account_money")
class AccountMoneyEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    accountId: Long,
    amount: Long

) : BaseEntity() {

    var accountId: Long = accountId
        protected set

    var amount: Long = amount
        protected set

    @OneToOne
    @JoinColumn(name = "account_entity_id")
    var account: AccountEntity? = null

}