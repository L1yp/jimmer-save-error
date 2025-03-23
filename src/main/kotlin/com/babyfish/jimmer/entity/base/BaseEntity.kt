package com.babyfish.jimmer.entity.base

import org.babyfish.jimmer.sql.*

@MappedSuperclass
interface BaseEntity : CreatedAt, CreatedBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long

}