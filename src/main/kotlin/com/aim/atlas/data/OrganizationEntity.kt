package com.aim.atlas.data

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "organizations")
class OrganizationEntity
    : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    @Column(name = "name")
    val name: String? = null

}


@Entity
@Table(name = "memberships")
class Membership
    : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    @Column(name = "name")
    val name: String? = null

    @Column(name = "alias")
    val fantasy: String? = null
}