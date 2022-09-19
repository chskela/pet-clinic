package com.chskela.petclinic.model

import org.hibernate.Hibernate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "specialties")
data class Specialty(
    override var id: Long? = null,

    @Column(name = "description")
    val description: String,

    @ManyToMany(mappedBy = "specialties")
    val vet: Set<Vet> = setOf()

) : BaseEntity(id) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Specialty

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , description = $description )"
    }

    companion object{
        fun notFound(message: String = "Not found"): Specialty = Specialty(description = message)
    }
}
