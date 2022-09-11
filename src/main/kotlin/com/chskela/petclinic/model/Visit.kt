package com.chskela.petclinic.model

import java.time.LocalDate

data class Visit(override var id: Long, val localDate: LocalDate, val description: String, val pet: Pet) :
    BaseEntity(id) {
}