package com.chskela.petclinic.model

import java.time.LocalDate

data class Pet(val petType: PetType, val owner: Owner, val birthDate: LocalDate)
