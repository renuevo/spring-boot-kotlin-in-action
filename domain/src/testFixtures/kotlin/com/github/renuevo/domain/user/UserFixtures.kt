package com.github.renuevo.domain.user

import com.github.renuevo.domain.account.AccountFixtures
import java.time.LocalDate

object UserFixtures {

    const val USER_ID: Long = 1

    fun `user object`(
        id: Long = AccountFixtures.ACCOUNT_ID,
        name: String = "퇴사몬",
        birthday: LocalDate = LocalDate.now(),
        age: Int = 27
    ) = User(id = id, name = name, birthday = birthday, age = age)

}