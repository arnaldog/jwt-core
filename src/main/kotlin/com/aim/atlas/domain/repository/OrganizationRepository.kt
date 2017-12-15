package com.aim.atlas.domain.repository

import com.aim.atlas.domain.Organization
import io.reactivex.Observable

interface OrganizationRepository {

    /**
     * 
     */
    fun getAllOrganizations() : Observable<Organization>
}