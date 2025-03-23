package com.babyfish.jimmer.config

import com.babyfish.jimmer.entity.base.BaseUpdateEntity
import com.babyfish.jimmer.entity.base.BaseUpdateEntityDraft
import org.babyfish.jimmer.kt.isLoaded
import org.babyfish.jimmer.meta.KeyMatcher
import org.babyfish.jimmer.sql.DraftInterceptor
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class BaseUpdateEntityDraftInterceptor: DraftInterceptor<BaseUpdateEntity, BaseUpdateEntityDraft> {

    override fun beforeSave(draft: BaseUpdateEntityDraft, original: BaseUpdateEntity?) {
        if (!isLoaded(draft, BaseUpdateEntity::updatedAt)) {
            draft.updatedAt = LocalDateTime.now()
        }

        if (!isLoaded(draft, BaseUpdateEntity::updatedBy)) {
            draft.updatedBy = 1L
        }

        if (original === null) {
            if (!isLoaded(draft, BaseUpdateEntity::createdAt)) {
                draft.createdAt = LocalDateTime.now()
            }

            if (!isLoaded(draft, BaseUpdateEntity::createdBy)) {
                draft.createdBy = 1L
            }
        }
    }

    override fun ignoreKeyOnly(group: KeyMatcher.Group): Boolean {
        return true
    }

}