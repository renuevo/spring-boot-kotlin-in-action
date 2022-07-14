package com.github.renuevo.account

data class Account(
    val id: Long,
    val money: Money
) {

    fun withdraw(money: Money): Boolean {
        this.money.minus(money)
        return this.money.isPositiveOrZero()
    }

    fun deposit(money: Money): Boolean{
        this.money.minus(money)
        return true
    }

}

data class Money(
    val amount: Long
) {

    fun isPositiveOrZero() = amount >= 0
    fun isNegative() = amount < 0
    fun isPositive() = amount > 0

    fun plus(money: Money) = amount + money.amount
    fun minus(money: Money) = amount - money.amount

}