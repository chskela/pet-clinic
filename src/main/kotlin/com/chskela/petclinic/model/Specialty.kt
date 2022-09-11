package com.chskela.petclinic.model

data class Specialty(override var id: Long = -1L, val description: String) : BaseEntity(id)
