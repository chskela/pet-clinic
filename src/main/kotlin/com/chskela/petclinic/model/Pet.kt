package com.chskela.petclinic.model

import java.time.LocalDate

data class Pet(
    override var id: Long = -1L,
    val name: String,
    val petType: PetType,
    val owner: Owner,
    val birthDate: LocalDate
) : BaseEntity(id)
