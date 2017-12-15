package com.aim.atlas.domain.specification

import com.aim.atlas.domain.Organization

class ValidOrganizationSpecification {

    companion object {
        fun isValid(org: Organization) : Boolean {
            return org.name.isEmpty() || org.id > 0
        }
    }
}