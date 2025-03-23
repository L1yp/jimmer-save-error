package com.babyfish.jimmer.entity.base

import org.babyfish.jimmer.sql.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
interface UpdatedAt {
    val updatedAt: LocalDateTime
}