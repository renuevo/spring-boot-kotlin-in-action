package com.github.renuevo.jpa.user

import com.github.renuevo.domain.user.UserFixtures
import com.github.renuevo.jpa.config.JpaConfig
import com.github.renuevo.jpa.user.entity.toEntity
import com.github.renuevo.jpa.user.repository.UserRepository
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.history.RevisionMetadata

@DataJpaTest
@Import(JpaConfig::class)
internal class EnversTest(private val userRepository: UserRepository) : ShouldSpec({

    context("envers test") {

        should("delete all") {

            withContext(Dispatchers.IO) {
                userRepository.save(UserFixtures.`user object`(id = 0).toEntity())
                userRepository.save(UserFixtures.`user object`(id = 0).toEntity())

                val userList = userRepository.findAll()
                userRepository.deleteAll(userList)

                val userHistory = userRepository.findRevisions(userList.first().id).content
                userHistory.size shouldBe 2
                userHistory[0].metadata.revisionType shouldBe RevisionMetadata.RevisionType.INSERT
                userHistory[1].metadata.revisionType shouldBe RevisionMetadata.RevisionType.DELETE
            }
        }


        should("save all") {

            withContext(Dispatchers.IO) {
                val saveList = listOf(UserFixtures.`user object`(id = 0).toEntity(), UserFixtures.`user object`(id = 0).toEntity())

                userRepository.saveAll(saveList)
                val userList = userRepository.findAll()
                userRepository.saveAll(userList.map { it.updateName("test")})

                val userHistory = userRepository.findRevisions(userList.first().id).content
                userHistory.size shouldBe 2
                userHistory[0].metadata.revisionType shouldBe RevisionMetadata.RevisionType.INSERT
                userHistory[1].metadata.revisionType shouldBe RevisionMetadata.RevisionType.UPDATE
            }
        }

    }

})