package com.aim.atlas.data.mapper

import com.aim.atlas.data.OrganizationEntity
import com.aim.atlas.domain.Organization

class OrganizationDataMapper {
    companion object {
        fun transform(organizationEntity: OrganizationEntity) : Organization {
            return Organization(organizationEntity.id ?: 0 , organizationEntity.name ?: "")
        }
    }
}