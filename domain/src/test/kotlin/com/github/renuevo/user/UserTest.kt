package com.github.renuevo.user

import com.github.renuevo.domain.user.UserFixtures
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe


internal class UserTest : ShouldSpec({

    context("유저 객체 생성") {

        should("나이가 1보다 작을때") {
            shouldThrow<RuntimeException> {
                UserFixtures.`user object`(age = 0)
            }.message shouldBe "어디서 왔니?"
        }

        should("이름이 비었을때") {
            shouldThrow<RuntimeException> {
                UserFixtures.`user object`(name = "")
            }.message shouldBe "이름이 올바르지 않다"
        }

    }
})