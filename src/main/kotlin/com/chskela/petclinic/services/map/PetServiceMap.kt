package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Pet
import com.chskela.petclinic.services.PetService
import org.springframework.stereotype.Service

@Service
class PetServiceMap : AbstractMapService<Pet>(), PetService {

}