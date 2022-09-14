package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Specialty
import com.chskela.petclinic.services.SpecialtyService
import org.springframework.stereotype.Service

@Service
class SpecialtyServiceMap : AbstractMapService<Specialty>(), SpecialtyService {
}