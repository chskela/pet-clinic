package com.chskela.petclinic.model

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
@Table(name = "vets")
data class Vet(
    override var id: Long = -1L,
    override val firstName: String,
    override val lastName: String,

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "vet_specialties",
        joinColumns = [JoinColumn(name = "vet_id")],
        inverseJoinColumns = [JoinColumn(name = "specialty_id")]
    )
    val specialties: Set<Specialty> = setOf()
) :
    Person(id, firstName, lastName) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Vet

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , firstName = $firstName , lastName = $lastName )"
    }
}
