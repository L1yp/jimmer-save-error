package com.babyfish.jimmer.entity.base

import org.babyfish.jimmer.sql.MappedSuperclass

@MappedSuperclass
interface OrderNo {

    val orderNo: Int

}