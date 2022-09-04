package com.chskela.petclinic.model

open class Person(override val id: Long, open val firstName: String, open val lastName: String) : BaseEntity(id) {
}