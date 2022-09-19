package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Pet
import com.chskela.petclinic.services.PetService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("default","map")
class PetMapService : AbstractMapService<Pet>(), PetService {

}