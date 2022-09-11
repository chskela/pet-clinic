package com.chskela.petclinic.model

data class Vet(
    override var id: Long = -1L,
    override val firstName: String,
    override val lastName: String,
    val specialties: Set<Specialty> = setOf()
) :
    Person(id, firstName, lastName) {
}
