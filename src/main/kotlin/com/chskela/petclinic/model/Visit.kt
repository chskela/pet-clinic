package com.chskela.petclinic.model

import org.hibernate.Hibernate
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "visits")
data class Visit(
    override var id: Long? = null,

    @Column(name = "date")
    val localDate: LocalDate,

    @Column(name = "description")
    val description: String,

    @ManyToOne
    @JoinColumn(name = "pet_id")
    val pet: Pet
) : BaseEntity(id) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Visit

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , localDate = $localDate , description = $description )"
    }

    companion object {
        fun notFound(message: String = "Not found"): Visit =
            Visit(id = -1L, description = message, localDate = LocalDate.now(), pet = Pet.notFound())
    }
}