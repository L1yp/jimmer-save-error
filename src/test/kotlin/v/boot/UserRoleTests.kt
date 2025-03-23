package v.boot

import jakarta.annotation.Resource
import org.babyfish.jimmer.sql.ast.mutation.AssociatedSaveMode
import org.babyfish.jimmer.sql.ast.mutation.SaveMode
import org.babyfish.jimmer.sql.kt.KSqlClient
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import v.boot.entity.User
import v.boot.entity.addBy

@SpringBootTest
class UserRoleTests {

    @Resource
    lateinit var sqlClient: KSqlClient


    @Test
    fun test() {
        val user = User {
            this.id = 1
            this.createdAt = System.currentTimeMillis()
            this.roleList().addBy {
                this.id = 1
                this.createdAt = System.currentTimeMillis()
            }
            this.roleList().addBy {
                this.id = 2
                this.createdAt = System.currentTimeMillis()
            }
        }
        sqlClient.save(user) {
            setMode(SaveMode.INSERT_IF_ABSENT)
            setAssociatedMode(User::roleList, AssociatedSaveMode.APPEND_IF_ABSENT)
        }
        sqlClient.save(user) {
            setMode(SaveMode.INSERT_IF_ABSENT)
            setAssociatedMode(User::roleList, AssociatedSaveMode.APPEND_IF_ABSENT)
        }

    }

}