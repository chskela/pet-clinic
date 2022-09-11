package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.PetType
import com.chskela.petclinic.services.PetTypeService
import org.springframework.stereotype.Service

@Service
class PetTypeServiceMap : AbstractMapService<PetType>(), PetTypeService {
}