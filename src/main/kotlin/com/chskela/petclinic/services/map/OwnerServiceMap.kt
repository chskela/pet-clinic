package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.services.OwnerService
import org.springframework.stereotype.Service

@Service
class OwnerServiceMap : AbstractMapService<Owner>(), OwnerService {
    override fun findByLastName(lastName: String): Owner {
        TODO("Not yet implemented")
    }
}