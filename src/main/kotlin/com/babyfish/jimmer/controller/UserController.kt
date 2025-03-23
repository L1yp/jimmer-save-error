package com.babyfish.jimmer.controller

import com.babyfish.jimmer.entity.Role
import com.babyfish.jimmer.entity.addBy
import com.babyfish.jimmer.entity.dto.UserAddInput
import com.babyfish.jimmer.repository.UserRepository
import org.babyfish.jimmer.sql.ast.mutation.AssociatedSaveMode
import org.babyfish.jimmer.sql.ast.mutation.SaveMode
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/user")
class UserController(val userRepository: UserRepository) {

    @PostMapping("/add")
    fun add(@RequestBody @Validated data: UserAddInput) {
        val codeList = data.roleList.map { it.code }

        val entity = data.toEntity {
            nickname = "Lyp"
            status = 1

            // 判断roleList里面是否包含默认角色, 如果不包含则新增默认角色
            // 正常
//            if (!codeList.contains(Role.DEFAULT_ROLE_KEY)) {
//                this.roleList().addBy {
//                    this.code = Role.DEFAULT_ROLE_KEY
//                }
//            }

            // 当takeIf返回false时(即客户端传入了default角色), save报错
            this.roleList().takeIf { !it.map { item -> item.code }.contains(Role.DEFAULT_ROLE_KEY) }?.addBy {
                code = Role.DEFAULT_ROLE_KEY
            }

            // 2
//            roleList = this.roleList().takeIf {
//                !it.map { item -> item.code }.contains(Role.DEFAULT_ROLE_KEY)
//            }?.addBy {
//                this.code = Role.DEFAULT_ROLE_KEY
//            } ?: this.roleList()
        }
        userRepository.save(entity, SaveMode.INSERT_ONLY, AssociatedSaveMode.MERGE)
    }


}