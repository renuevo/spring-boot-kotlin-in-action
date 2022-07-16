package com.github.renuevo.jpa.common

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    var createdDate: LocalDateTime = LocalDateTime.MIN

    @CreatedBy
    @Column(updatable = false)
    var createdBy: String? = null

    @LastModifiedDate
    var updatedDate: LocalDateTime = LocalDateTime.MIN

    @LastModifiedBy
    var updatedBy: String? = null

}