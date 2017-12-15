package com.aim.atlas.data.repository.datasource.jpa

import com.aim.atlas.data.OrganizationEntity
import com.aim.atlas.data.repository.datasource.OrganizationDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrganizationJPADataSource constructor(@Autowired val organizationJPARepository: OrganizationJPARepository) : OrganizationDataSource {
    override fun findAll(): List<OrganizationEntity> {
        return organizationJPARepository.findAll().toList()
    }
}