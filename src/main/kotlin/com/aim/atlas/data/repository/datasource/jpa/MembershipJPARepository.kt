package com.aim.atlas.data.repository.datasource.jpa

import com.aim.atlas.data.Membership
import org.springframework.data.repository.CrudRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.stereotype.Repository

@RepositoryRestResource
interface MembershipJPARepository : CrudRepository<Membership, Long> {

}