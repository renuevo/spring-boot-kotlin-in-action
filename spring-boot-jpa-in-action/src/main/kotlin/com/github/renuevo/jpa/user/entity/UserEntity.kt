package com.github.renuevo.jpa.user.entity

import com.github.renuevo.jpa.account.entity.AccountEntity
import com.github.renuevo.jpa.common.BaseEntity
import com.github.renuevo.domain.user.User
import java.time.LocalDate
import java.util.TreeSet
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table


@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    val birthday: LocalDate,

    val age: Int

) : BaseEntity() {

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var accountList: MutableSet<AccountEntity> = TreeSet()
}


fun UserEntity.toUser() = User(
    id = id,
    name = name,
    birthday = birthday,
    age = age
)