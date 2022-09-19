package com.chskela.petclinic.model

import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class Person(
    override var id: Long?,

    @Column(name = "first_name")
    open val firstName: String,

    @Column(name = "last_name")
    open val lastName: String,
) : BaseEntity(id)