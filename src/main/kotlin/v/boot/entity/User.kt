package v.boot.entity

import org.babyfish.jimmer.sql.Entity
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.ManyToMany

@Entity
interface User {

    @Id
    val id: Int

    val createdAt: Long

    @ManyToMany
    val roleList: List<Role>

}