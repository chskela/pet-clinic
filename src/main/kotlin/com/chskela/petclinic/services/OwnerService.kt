package com.chskela.petclinic.services

import com.chskela.petclinic.model.Owner

interface OwnerService : CrudService<Owner, Long> {

    fun findByLastName(lastName: String): Owner?
}