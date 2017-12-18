package com.aim.atlas.app.controller

import com.aim.atlas.data.ApplicationUser
import com.aim.atlas.data.repository.datasource.jpa.ApplicationUserRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sun.security.x509.OIDMap.addAttribute
import org.springframework.security.core.userdetails.UserDetails




@RestController
@RequestMapping("/users")
class UserController(private val applicationUserRepository: ApplicationUserRepository,
                     private val bCryptPasswordEncoder: BCryptPasswordEncoder) {

    @PostMapping("/sign-up")
    @PreAuthorize("hasAnyAuthority('ROOT_USER')")
    fun signUp(@RequestBody user: ApplicationUser) {
        user.password = bCryptPasswordEncoder.encode(user.password)
        applicationUserRepository.save(user)
    }
}