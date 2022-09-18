package com.chskela.petclinic.repositories

import com.chskela.petclinic.model.Vet
import org.springframework.data.repository.CrudRepository

interface VetRepository : CrudRepository<Vet, Long> {
}