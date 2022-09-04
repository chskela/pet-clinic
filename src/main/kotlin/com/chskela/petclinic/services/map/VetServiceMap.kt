package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Vet
import com.chskela.petclinic.services.VetService
import org.springframework.stereotype.Service

@Service
class VetServiceMap : AbstractMapService<Vet>(), VetService {
}