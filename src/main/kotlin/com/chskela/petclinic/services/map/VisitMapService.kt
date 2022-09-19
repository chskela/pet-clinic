package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Visit
import com.chskela.petclinic.services.VisitService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("map")
class VisitMapService : AbstractMapService<Visit>(), VisitService {
}