package com.aim.atlas.data.repository.datasource

import com.aim.atlas.data.OrganizationEntity

interface OrganizationDataSource {
    fun findAll() : List<OrganizationEntity>
}