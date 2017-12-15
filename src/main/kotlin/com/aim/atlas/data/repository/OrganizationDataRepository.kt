package com.aim.atlas.data.repository

import com.aim.atlas.data.mapper.OrganizationDataMapper
import com.aim.atlas.data.repository.datasource.OrganizationDataSource
import com.aim.atlas.domain.Organization
import com.aim.atlas.domain.repository.OrganizationRepository
import com.aim.atlas.domain.specification.ValidOrganizationSpecification
import io.reactivex.Observable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrganizationDataRepository constructor(@Autowired var dataSource: OrganizationDataSource): OrganizationRepository {

    override fun getAllOrganizations(): Observable<Organization> {
        return Observable
                .fromIterable(dataSource.findAll())
                .map(OrganizationDataMapper.Companion::transform)
                .filter(ValidOrganizationSpecification.Companion::isValid)
    }
}