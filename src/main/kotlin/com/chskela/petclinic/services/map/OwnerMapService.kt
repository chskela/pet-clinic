package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.services.OwnerService
import com.chskela.petclinic.services.PetService
import com.chskela.petclinic.services.PetTypeService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("default","map")
class OwnerMapService(private val petTypeService: PetTypeService, private val petService: PetService) :
    AbstractMapService<Owner>(), OwnerService {
    override fun findByLastName(lastName: String): Owner? {
        return super.findAll().findLast { it.lastName == lastName }
    }

    override fun save(entity: Owner): Owner {
        return super.save(
            if (entity.pets.isNotEmpty()) {
                entity.copy(pets = entity.pets.map { pet ->
                    val candidate = if (pet.id == null) {
                        petService.save(pet)
                    } else pet

                    if (candidate.petType.id == null) {
                        candidate.copy(petType = petTypeService.save(candidate.petType))
                    } else candidate

                }.toSet())
            } else {
                entity
            }
        )
    }
}