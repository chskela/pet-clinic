package com.chskela.petclinic.model

open class Person(override var id: Long, open val firstName: String, open val lastName: String, ) : BaseEntity(id) {
}