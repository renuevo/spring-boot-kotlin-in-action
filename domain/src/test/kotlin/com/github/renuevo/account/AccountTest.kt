package com.github.renuevo.account

import com.github.renuevo.domain.AccountFixtures
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

internal class AccountTest : ShouldSpec({


    context("account 객체 생성") {

        should("금액이 0보다 작을때") {
            shouldThrow<RuntimeException> {
                AccountFixtures.`account object`(money = AccountFixtures.`money object`(-1))
            }.message shouldBe "돈이 없어요!"
        }

        should("계좌번호가 너무 짧을때") {
            shouldThrow<RuntimeException> {
                AccountFixtures.`account object`(accountNumber = "11")
            }.message shouldBe "계좌번호는 6자리 이상!"
        }

    }

})