package v.boot.entity

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Id

@Entity
interface Role {

    @Id
    val id: Int

    val createdAt: Long

}