package com.chskela.petclinic.services.springdatajpa

import com.chskela.petclinic.model.Specialty
import com.chskela.petclinic.repositories.SpecialtyRepository
import com.chskela.petclinic.services.SpecialtyService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("springdatajpa")
class SpecialtySDJpaService(private val specialtyRepository: SpecialtyRepository) : SpecialtyService {
    override fun findAll(): Set<Specialty> {
        return specialtyRepository.findAll().toSet()
    }

    override fun findById(id: Long): Specialty {
        return specialtyRepository.findById(id).orElse(Specialty.notFound())
    }

    override fun save(entity: Specialty): Specialty {
        return specialtyRepository.save(entity)
    }

    override fun delete(entity: Specialty) {
        specialtyRepository.delete(entity)
    }

    override fun deleteById(id: Long) {
        specialtyRepository.deleteById(id)
    }
}