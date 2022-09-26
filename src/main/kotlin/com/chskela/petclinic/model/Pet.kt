package com.chskela.petclinic.model

import org.hibernate.Hibernate
import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name = "pets")
data class Pet(
    override var id: Long? = null,

    @Column(name = "name")
    val name: String,

    @ManyToOne
    @JoinColumn(name = "type_id")
    val petType: PetType,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "owner_id")
    val owner: Owner,

    @Column(name = "birth_date")
    val birthDate: LocalDate,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "pet")
    val visits: Set<Visit> = setOf()
) : BaseEntity(id) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Pet

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , petType = $petType , owner = $owner , birthDate = $birthDate )"
    }


    companion object {
        fun notFound(message: String = "Not found"): Pet = Pet(
            id = -1L,
            name = message,
            owner = Owner.notFound(),
            petType = PetType.notFound(),
            birthDate = LocalDate.now()
        )
    }
}
