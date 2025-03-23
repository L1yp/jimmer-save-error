package com.babyfish.jimmer.entity

import com.babyfish.jimmer.entity.base.BaseUpdateEntity
import com.babyfish.jimmer.entity.base.Status
import org.babyfish.jimmer.Formula
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Key
import org.babyfish.jimmer.sql.KeyUniqueConstraint
import org.babyfish.jimmer.sql.ManyToMany

@Entity
@KeyUniqueConstraint(noMoreUniqueConstraints = true)
interface User: BaseUpdateEntity, Status {

    /**
     * 用户名
     */
    @Key(group = "username")
    val username: String


    val nickname: String


    @ManyToMany
    val roleList: List<Role>

    @Formula(dependencies = ["status"])
    val isNotValid: Boolean
        get() = status != 1


}