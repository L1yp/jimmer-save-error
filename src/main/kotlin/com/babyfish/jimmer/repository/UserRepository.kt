package com.babyfish.jimmer.repository

import com.babyfish.jimmer.entity.User
import org.babyfish.jimmer.spring.repo.support.AbstractKotlinRepository
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.springframework.stereotype.Repository

@Repository
class UserRepository(sqlClient: KSqlClient): AbstractKotlinRepository<User, Long>(sqlClient) {
}