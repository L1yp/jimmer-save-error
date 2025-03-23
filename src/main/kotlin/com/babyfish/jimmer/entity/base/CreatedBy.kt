package com.babyfish.jimmer.entity.base

import org.babyfish.jimmer.sql.MappedSuperclass

@MappedSuperclass
interface CreatedBy {
    val createdBy: Long
}