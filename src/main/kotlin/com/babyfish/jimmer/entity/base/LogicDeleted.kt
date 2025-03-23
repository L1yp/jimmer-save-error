package com.babyfish.jimmer.entity.base

import org.babyfish.jimmer.sql.LogicalDeleted
import org.babyfish.jimmer.sql.MappedSuperclass

@MappedSuperclass
interface LogicDeleted {

    @LogicalDeleted("true")
    val deleted: Boolean

}