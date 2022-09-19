package com.chskela.petclinic.services.springdatajpa

import com.chskela.petclinic.model.Pet
import com.chskela.petclinic.repositories.PetRepository
import com.chskela.petclinic.services.PetService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("springdatajpa")
class PetSDJpaService(private val petRepository: PetRepository) : PetService {
    override fun findAll(): Set<Pet> {
        return petRepository.findAll().toSet()
    }

    override fun findById(id: Long): Pet {
        return petRepository.findById(id).orElse(Pet.notFound())
    }

    override fun save(entity: Pet): Pet {
        return petRepository.save(entity)
    }

    override fun delete(entity: Pet) {
        petRepository.delete(entity)
    }

    override fun deleteById(id: Long) {
        petRepository.deleteById(id)
    }
}