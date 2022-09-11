package com.chskela.petclinic.model

data class PetType(override var id: Long = -1L, val name: String) : BaseEntity(id) {

}
