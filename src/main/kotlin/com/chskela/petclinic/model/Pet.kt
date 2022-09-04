package com.chskela.petclinic.model

import java.time.LocalDate

class Pet(override var id: Long = -1L, val petType: PetType, val owner: Owner, val birthDate: LocalDate) : BaseEntity(id)
