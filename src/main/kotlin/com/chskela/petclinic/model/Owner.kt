package com.chskela.petclinic.model

import org.hibernate.Hibernate
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "owners")
data class Owner(
    override var id: Long = -1L,
    override val firstName: String,
    override val lastName: String,

    @Column(name = "address")
    val address: String = "",

    @Column(name = "city")
    val city: String = "",

    @Column(name = "telephone")
    val telephone: String = "",

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "owner")
    val pets: Set<Pet> = setOf()
) :
    Person(id, firstName, lastName) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Owner

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , firstName = $firstName , lastName = $lastName , address = $address , city = $city , telephone = $telephone )"
    }
}
