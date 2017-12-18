package com.aim.atlas.data.repository.datasource.jpa

import com.aim.atlas.data.OrganizationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@RepositoryRestResource(path = "organizaciones")
interface OrganizationJPARepository : CrudRepository<OrganizationEntity, Long> {

    fun findByName(name: String) : Collection<OrganizationEntity>
}