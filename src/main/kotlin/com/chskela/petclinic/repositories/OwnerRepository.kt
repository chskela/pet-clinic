package com.chskela.petclinic.repositories

import com.chskela.petclinic.model.Owner
import org.springframework.data.repository.CrudRepository

interface OwnerRepository : CrudRepository<Owner, Long> {
}