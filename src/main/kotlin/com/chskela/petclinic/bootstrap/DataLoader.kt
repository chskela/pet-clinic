package com.chskela.petclinic.bootstrap

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.model.Pet
import com.chskela.petclinic.model.PetType
import com.chskela.petclinic.model.Vet
import com.chskela.petclinic.services.OwnerService
import com.chskela.petclinic.services.PetTypeService
import com.chskela.petclinic.services.VetService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataLoader(
    private val ownerService: OwnerService,
    private val vetService: VetService,
    private val petTypeService: PetTypeService
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        val savedDogPetType = petTypeService.save(PetType(name = "Dog"))

        val savedCatPetType = petTypeService.save(PetType(name = "Cat"))

        println("Loading PetType...")

        val owner1 = Owner(
            firstName = "Michael",
            lastName = "Weston",
            address = "123 Street",
            city = "Miami",
            telephone = "1231231234",
        )

        val mikes = Pet(
            name = "Rosco",
            petType = savedDogPetType,
            owner = owner1,
            birthDate = LocalDate.now()
        )
        ownerService.save(owner1.copy(pets = owner1.pets.plus(mikes)))

        val owner2 = Owner(
            firstName = "Fiona",
            lastName = "Glenanne",
            address = "123 Street2",
            city = "Miami2",
            telephone = "5645645645456"
        )
        val fiona = Pet(
            name = "Cat",
            petType = savedCatPetType,
            owner = owner2,
            birthDate = LocalDate.now()
        )
        ownerService.save(owner2.copy(pets = owner2.pets.plus(fiona)))

        println("Loading owners...")

        val vet1 = Vet(firstName = "Same", lastName = "Axe")
        vetService.save(vet1)

        val vet2 = Vet(firstName = "Same2", lastName = "Axe2")
        vetService.save(vet2)

        println("Loading vets...")
    }
}