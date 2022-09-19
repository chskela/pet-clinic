package com.chskela.petclinic.services.springdatajpa

import com.chskela.petclinic.model.PetType
import com.chskela.petclinic.repositories.PetTypeRepository
import com.chskela.petclinic.services.PetTypeService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("springdatajpa")
class PetTypeSDJpaService(private val petTypeRepository: PetTypeRepository) : PetTypeService {
    override fun findAll(): Set<PetType> {
        return petTypeRepository.findAll().toSet()
    }

    override fun deleteById(id: Long) {
        petTypeRepository.deleteById(id)
    }

    override fun delete(entity: PetType) {
        petTypeRepository.delete(entity)
    }

    override fun save(entity: PetType): PetType {
        return petTypeRepository.save(entity)
    }

    override fun findById(id: Long): PetType? {
        return petTypeRepository.findById(id).orElse(PetType(name = "Not found"))
    }
}