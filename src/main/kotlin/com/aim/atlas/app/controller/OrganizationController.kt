package com.aim.atlas.app.controller

import com.aim.atlas.domain.repository.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMethod



@RestController
@RequestMapping("/orgs")
class OrganizationController constructor(@Autowired val repository : OrganizationRepository) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    @PreAuthorize("hasAuthority('read:contacts')")
    fun readBookmarks() = repository.getAllOrganizations()
}