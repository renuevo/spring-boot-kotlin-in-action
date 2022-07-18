package com.github.renuevo.account

data class Account(
    val id: Long,
    val accountNumber: String,
    val money: Money
) {

    init {
        if (accountNumber.length > 6) throw RuntimeException("계좌번호는 6자리 이상!")
    }

    fun withdraw(money: Money): Boolean {
        this.money.minus(money)
        return this.money.isPositiveOrZero()
    }

    fun deposit(money: Money): Boolean {
        this.money.minus(money)
        return true
    }

}

data class Money(
    var amount: Long
) {

    init {
        if (amount < 0) throw RuntimeException("돈이 없어요!")
    }


    fun isPositiveOrZero() = amount >= 0
    fun isNegative() = amount < 0
    fun isPositive() = amount > 0

    fun plus(money: Money) {
        amount += money.amount
    }

    fun minus(money: Money) {
        amount -= money.amount
    }

}