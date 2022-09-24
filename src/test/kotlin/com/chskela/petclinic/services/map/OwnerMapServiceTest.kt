package com.chskela.petclinic.services.map

import com.chskela.petclinic.model.Owner
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class OwnerMapServiceTest {

    lateinit var ownerMapService: OwnerMapService
    private val ownerId = 1L
    private val lastName = "lastName"
    private val testOwner = Owner(
        ownerId,
        "firstName",
        lastName,
        "address",
        "city",
        "telephone"
    )

    @BeforeEach
    fun setUp() {
        ownerMapService = OwnerMapService(PetTypeMapService(), PetMapService())
        ownerMapService.save(testOwner)
    }

    @Test
    fun findAll() {
        assertEquals(ownerMapService.findAll().size, 1)
    }

    @Test
    fun findById() {
        assertEquals(ownerMapService.findById(ownerId), testOwner)
    }
    @Test
    fun findByIdNotFound() {
        assertEquals(ownerMapService.findById(0L), null)
    }

    @Test
    fun saveExistingId() {
        assertEquals(ownerMapService.save(testOwner.copy(id = 2)), testOwner.copy(id = 2))
    }

    @Test
    fun saveNoId() {
        assertNotNull(ownerMapService.save(testOwner.copy(id = null)).id)
    }

    @Test
    fun delete() {
        ownerMapService.delete(testOwner)
        assertEquals(ownerMapService.findAll().size, 0)
    }

    @Test
    fun deleteById() {
        ownerMapService.deleteById(ownerId)
        assertEquals(ownerMapService.findAll().size, 0)
    }

    @Test
    fun findByLastName() {
        assertEquals(ownerMapService.findByLastName(lastName), testOwner)
    }

    @Test
    fun findByLastNameNotFound() {
        assertEquals(ownerMapService.findByLastName("Not found"), null)
    }
}