package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Pet
import com.chskela.petclinic.services.CrudService

class PetServiceMap : AbstractMapService<Pet, Long>(), CrudService<Pet, Long> {
    override fun save(entity: Pet): Pet {
        super.save(entity.id ?: 0, entity)
        return entity
    }
}