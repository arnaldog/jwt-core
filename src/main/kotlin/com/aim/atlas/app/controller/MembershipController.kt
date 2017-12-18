package com.aim.atlas.app.controller

import com.aim.atlas.data.repository.datasource.jpa.MembershipJPARepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("memberships.php")
class MembershipController(val repository: MembershipJPARepository){

    @GetMapping("/")
    fun getMemberships() = repository.findAll()
}