package com.chskela.petclinic.repositories

import com.chskela.petclinic.model.Visit
import org.springframework.data.repository.CrudRepository

interface VisitRepository : CrudRepository<Visit, Long> {
}