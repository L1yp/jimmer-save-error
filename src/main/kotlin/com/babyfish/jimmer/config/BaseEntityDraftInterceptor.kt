package com.babyfish.jimmer.config

import com.babyfish.jimmer.entity.base.BaseEntity
import com.babyfish.jimmer.entity.base.BaseEntityDraft
import org.babyfish.jimmer.kt.isLoaded
import org.babyfish.jimmer.meta.KeyMatcher
import org.babyfish.jimmer.sql.DraftInterceptor
import org.springframework.stereotype.Component
import java.time.LocalDateTime

//@Component
class BaseEntityDraftInterceptor: DraftInterceptor<BaseEntity, BaseEntityDraft> {

    override fun beforeSave(draft: BaseEntityDraft, original: BaseEntity?) {
        if (original === null) {
            if (!isLoaded(draft, BaseEntity::createdAt)) {
                draft.createdAt = LocalDateTime.now()
            }

            if (!isLoaded(draft, BaseEntity::createdBy)) {
                draft.createdBy = 1L
            }
        }
    }

    override fun ignoreKeyOnly(group: KeyMatcher.Group): Boolean {
        return true
    }
}