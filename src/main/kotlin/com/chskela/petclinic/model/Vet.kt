package com.chskela.petclinic.model

data class Vet(override val id: Long, override val firstName: String, override val lastName: String) :
    Person(id, firstName, lastName) {
}
