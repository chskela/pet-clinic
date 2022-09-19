package com.chskela.petclinic.services.springdatajpa

import com.chskela.petclinic.model.Vet
import com.chskela.petclinic.repositories.VetRepository
import com.chskela.petclinic.services.VetService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("springdatajpa")
class VetSDJpaService(private val vetRepository: VetRepository) : VetService {
    override fun findAll(): Set<Vet> {
        return vetRepository.findAll().toSet()
    }

    override fun findById(id: Long): Vet? {
        return vetRepository.findById(id).orElse(Vet(firstName = "Not found", lastName = "Not found"))
    }

    override fun save(entity: Vet): Vet {
        return vetRepository.save(entity)
    }

    override fun delete(entity: Vet) {
        vetRepository.delete(entity)
    }

    override fun deleteById(id: Long) {
        vetRepository.deleteById(id)
    }
}