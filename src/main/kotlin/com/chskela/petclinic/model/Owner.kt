package com.chskela.petclinic.model

data class Owner(
    override var id: Long = -1L,
    override val firstName: String,
    override val lastName: String,
    val pets: Set<Pet>
) :
    Person(id, firstName, lastName) {
}
