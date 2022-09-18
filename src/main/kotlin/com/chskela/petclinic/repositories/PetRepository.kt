package com.chskela.petclinic.repositories

import com.chskela.petclinic.model.Pet
import org.springframework.data.repository.CrudRepository

interface PetRepository : CrudRepository<Pet, Long> {
}