package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Vet
import com.chskela.petclinic.services.SpecialtyService
import com.chskela.petclinic.services.VetService
import org.springframework.stereotype.Service

@Service
class VetServiceMap(private val specialtyService: SpecialtyService) : AbstractMapService<Vet>(), VetService {

    override fun save(entity: Vet): Vet {
        return super.save(
            if (entity.specialties.isNotEmpty()) {
                entity.copy(specialties = entity.specialties.map { specialty ->
                    if (specialty.id == -1L) {
                        specialtyService.save(specialty)
                    } else specialty
                }.toSet())
            } else entity
        )
    }
}