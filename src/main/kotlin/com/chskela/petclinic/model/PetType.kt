package com.chskela.petclinic.model

import org.hibernate.Hibernate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "types")
data class PetType(
    override var id: Long? = null,

    @Column(name = "name")
    val name: String
) : BaseEntity(id) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PetType

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name )"
    }

    companion object {
        fun notFound(message: String = "Not found"): PetType = PetType(id = -1L, name = message)
    }

}
