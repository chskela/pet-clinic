package com.chskela.petclinic.services.springdatajpa

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.repositories.OwnerRepository
import com.chskela.petclinic.services.OwnerService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("springdatajpa")
class OwnerSDJpaService(private val ownerRepository: OwnerRepository) : OwnerService {
    override fun findByLastName(lastName: String): Owner {
        return ownerRepository.findByLastName(lastName)
    }

    override fun findAll(): Set<Owner> {
        return ownerRepository.findAll().toSet()
    }

    override fun findById(id: Long): Owner {
        return ownerRepository.findById(id).orElse(Owner(firstName = "Not found", lastName = "Not found"))
    }

    override fun save(entity: Owner): Owner {
        return ownerRepository.save(entity)
    }

    override fun delete(entity: Owner) {
        ownerRepository.delete(entity)
    }

    override fun deleteById(id: Long) {
        ownerRepository.deleteById(id)
    }
}