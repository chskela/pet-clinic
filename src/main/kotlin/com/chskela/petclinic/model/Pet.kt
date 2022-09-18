package com.chskela.petclinic.model

import org.hibernate.Hibernate
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table


@Entity
@Table(name = "pets")
data class Pet(
    override var id: Long = -1L,

    @Column(name = "name")
    val name: String,

    @ManyToOne
    @JoinColumn(name = "type_id")
    val petType: PetType,

    @ManyToOne
    @JoinColumn(name = "owner_id", )
    val owner: Owner,

    @Column(name = "birth_date")
    val birthDate: LocalDate
) : BaseEntity(id) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Pet

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , petType = $petType , owner = $owner , birthDate = $birthDate )"
    }
}
