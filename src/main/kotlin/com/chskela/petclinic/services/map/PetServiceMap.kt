package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Pet
import com.chskela.petclinic.services.PetService
import org.springframework.stereotype.Service

@Service
class PetServiceMap : AbstractMapService<Pet, Long>(), PetService {
    override fun save(entity: Pet): Pet {
        super.save(entity.id ?: 0, entity)
        return entity
    }
}