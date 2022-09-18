package com.chskela.petclinic.repositories

import com.chskela.petclinic.model.Specialty
import org.springframework.data.repository.CrudRepository

interface SpecialtyRepository :  CrudRepository<Specialty, Long>{
}