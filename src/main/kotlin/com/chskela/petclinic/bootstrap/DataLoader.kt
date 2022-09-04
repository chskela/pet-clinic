package com.chskela.petclinic.bootstrap

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.model.Vet
import com.chskela.petclinic.services.OwnerService
import com.chskela.petclinic.services.VetService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(private val ownerService: OwnerService, private val vetService: VetService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val owner1 = Owner( firstName = "Michael", lastName = "Weston")
        ownerService.save(owner1)

        val owner2 = Owner( firstName = "Fiona", lastName = "Glenanne")
        println(owner2)
        ownerService.save(owner2)

        println("Loading owners...")

        val vet1 = Vet( firstName = "Same", lastName = "Axe")
        vetService.save(vet1)

        val vet2 = Vet(firstName =  "Same2", lastName = "Axe2")
        vetService.save(vet2)

        println("Loading vets...")
    }
}