package com.github.renuevo.domain.user

import java.time.LocalDate

data class User(
    val id: Long,
    val name: String,
    val birthday: LocalDate,
    val age: Int
) {

    init {
        if (LocalDate.now().isAfter(birthday) || age < 1) throw RuntimeException("어디서 왔니?")
        if (name.isEmpty()) throw RuntimeException("이름이 올바르지 않다")
    }

}