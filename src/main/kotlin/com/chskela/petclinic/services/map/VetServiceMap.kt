package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Vet
import com.chskela.petclinic.services.CrudService

class VetServiceMap : AbstractMapService<Vet, Long>(), CrudService<Vet, Long> {
    override fun save(entity: Vet): Vet {
        super.save(entity.id ?: 0, entity)
        return entity
    }
}