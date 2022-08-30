package com.chskela.petclinic.services

import com.chskela.petclinic.model.Pet

interface PetService {

    fun findById(id: Long): Pet

    fun save(pet: Pet)

    fun findAll(): Set<Pet>
}