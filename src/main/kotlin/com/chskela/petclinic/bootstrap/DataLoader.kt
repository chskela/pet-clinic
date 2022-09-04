package com.chskela.petclinic.bootstrap

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.model.Vet
import com.chskela.petclinic.services.OwnerService
import com.chskela.petclinic.services.VetService
import com.chskela.petclinic.services.map.OwnerServiceMap
import com.chskela.petclinic.services.map.VetServiceMap
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(private val ownerService: OwnerService, private val vetService: VetService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val owner1 = Owner(1L, "Michael", "Weston")
        ownerService.save(owner1)

        val owner2 = Owner(2L, "Fiona", "Glenanne")
        ownerService.save(owner2)

        println("Loading owners...")

        val vet1 = Vet(1L, "Same", "Axe")
        vetService.save(vet1)

        val vet2 = Vet(2L, "Same", "Axe")
        vetService.save(vet2)

        println("Loading vets...")
    }
}