package com.babyfish.jimmer.entity.base

import org.babyfish.jimmer.sql.MappedSuperclass

@MappedSuperclass
interface BaseUpdateEntity : BaseEntity, UpdatedAt, UpdatedBy {

}