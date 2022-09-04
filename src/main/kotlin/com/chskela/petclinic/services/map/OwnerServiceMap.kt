package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.services.OwnerService
import org.springframework.stereotype.Service

@Service
class OwnerServiceMap : AbstractMapService<Owner, Long>(), OwnerService{
    override fun findByLastName(lastName: String): Owner {
        TODO("Not yet implemented")
    }

    override fun save(entity: Owner): Owner {
        super.save(entity.id ?: 0, entity)
        return entity
    }
}