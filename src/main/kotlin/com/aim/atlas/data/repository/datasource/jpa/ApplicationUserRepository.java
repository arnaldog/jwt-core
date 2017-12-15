package com.aim.atlas.data.repository.datasource.jpa;

import com.aim.atlas.data.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "application_users")
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    /**
     * This method enable the usage for authentication flow
     * @param username
     * @return {@link ApplicationUser}
     */
    ApplicationUser findByUsername(String username);
}