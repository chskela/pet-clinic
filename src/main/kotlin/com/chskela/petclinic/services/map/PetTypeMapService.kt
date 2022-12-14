package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.PetType
import com.chskela.petclinic.services.PetTypeService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("default","map")
class PetTypeMapService : AbstractMapService<PetType>(), PetTypeService {
}