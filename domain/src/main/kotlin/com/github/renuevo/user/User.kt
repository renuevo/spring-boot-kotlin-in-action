package com.github.renuevo.user

import java.time.LocalDate

data class User(
    val id: Long,
    val name: String,
    val birthday: LocalDate,
    val age: Int
) {

    init {
        if (LocalDate.now().isAfter(birthday)) throw RuntimeException("어디서 왔니?")
    }

}