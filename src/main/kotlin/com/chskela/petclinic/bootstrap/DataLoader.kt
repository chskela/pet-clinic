package com.chskela.petclinic.bootstrap

import com.chskela.petclinic.model.*
import com.chskela.petclinic.services.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataLoader(
    private val ownerService: OwnerService,
    private val vetService: VetService,
    private val petTypeService: PetTypeService,
    private val specialtyService: SpecialtyService,
    private val visitService: VisitService
) : CommandLineRunner {

    override fun run(vararg args: String?) {

        if (petTypeService.findAll().isEmpty()){
            loadData()
        }
    }

    private fun loadData() {
        val savedDogPetType = petTypeService.save(PetType(name = "Dog"))

        val savedCatPetType = petTypeService.save(PetType(name = "Cat"))

        println("Loading PetType...")


        val saveRadiology = specialtyService.save(Specialty(description = "radiology"))
        val saveSurgery = specialtyService.save(Specialty(description = "surgery"))
        val saveDentistry = specialtyService.save(Specialty(description = "dentistry"))

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

        val catVisit = Visit(pet = fiona, localDate = LocalDate.now(), description = "Test fiona")
        visitService.save(catVisit)

        val vet1 = Vet(firstName = "Same", lastName = "Axe", specialties = setOf(saveRadiology))
        vetService.save(vet1)

        val vet2 = Vet(firstName = "Same2", lastName = "Axe2", specialties = setOf(saveDentistry))
        vetService.save(vet2)

        println("Loading vets...")
    }
}