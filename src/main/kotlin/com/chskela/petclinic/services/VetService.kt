package com.chskela.petclinic.services

import com.chskela.petclinic.model.Vet

interface VetService {

    fun findById(id: Long): Vet

    fun save(vet: Vet)

    fun findAll(): Set<Vet>
}