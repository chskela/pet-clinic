package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Specialty
import com.chskela.petclinic.services.SpecialtyService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("map")
class SpecialtyServiceMap : AbstractMapService<Specialty>(), SpecialtyService {
}