package com.babyfish.jimmer.entity

import com.babyfish.jimmer.entity.base.BaseUpdateEntity
import com.babyfish.jimmer.entity.base.OrderNo
import com.babyfish.jimmer.entity.base.Status
import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Key
import org.babyfish.jimmer.sql.KeyUniqueConstraint
import org.babyfish.jimmer.sql.ManyToMany

@Entity
@KeyUniqueConstraint
interface Role: BaseUpdateEntity, Status, OrderNo {
    // 角色标识
    @Key(group = "uidx_key")
    val code: String
    // 角色名称
    val name: String

    @ManyToMany(mappedBy = "roleList")
    val userList: List<User>

    companion object {
        const val ADMIN_ROLE_KEY = "admin"
        const val DEFAULT_ROLE_KEY = "default"
    }
}