package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.services.CrudService

class OwnerServiceMap : AbstractMapService<Owner, Long>(), CrudService<Owner, Long> {
    override fun save(entity: Owner): Owner {
        super.save(entity.id ?: 0, entity)
        return entity
    }
}