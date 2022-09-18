package com.chskela.petclinic.repositories

import com.chskela.petclinic.model.PetType
import org.springframework.data.repository.CrudRepository

interface PetTypeRepository : CrudRepository<PetType, Long> {
}