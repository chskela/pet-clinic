package com.chskela.petclinic.services

import com.chskela.petclinic.model.Owner

interface OwnerService {

    fun findByLastName(lastName: String): Owner

    fun findById(id: Long): Owner

    fun save(owner: Owner)

    fun findAll(): Set<Owner>
}