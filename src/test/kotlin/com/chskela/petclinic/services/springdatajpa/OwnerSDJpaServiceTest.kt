package com.chskela.petclinic.services.springdatajpa

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.repositories.OwnerRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class OwnerSDJpaServiceTest {

    @Mock
    lateinit var ownerRepository: OwnerRepository

    @InjectMocks
    lateinit var ownerSDJpaService: OwnerSDJpaService

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

    @Test
    fun findByLastName() {
        `when`(ownerRepository.findByLastName(anyString())).thenReturn(testOwner)

        val owners = ownerSDJpaService.findByLastName(lastName)

        assertEquals(lastName, owners.lastName)

        verify(ownerRepository, times(1)).findByLastName(anyString())
    }

    @Test
    fun findAll() {
        val returnSet = setOf(testOwner, Owner.notFound())
        `when`(ownerRepository.findAll()).thenReturn(returnSet)

        val owners = ownerSDJpaService.findAll()

        assertNotNull(owners)
        assertEquals(2, owners.size)
    }

    @Test
    fun findById() {
        `when`(ownerRepository.findById(anyLong())).thenReturn(Optional.of(testOwner))

        val owners = ownerSDJpaService.findById(ownerId)

        assertNotNull(owners)
    }

    @Test
    fun findByIdNotFound() {
        `when`(ownerRepository.findById(anyLong())).thenReturn(Optional.empty())

        val ownersNotFound = ownerSDJpaService.findById(anyLong())

        assertEquals(ownersNotFound, Owner.notFound())
    }

    @Test
    fun save() {
        `when`(ownerRepository.save(any())).thenReturn(testOwner)

        val owners = ownerSDJpaService.save(testOwner)

        assertNotNull(owners)

        verify(ownerRepository, times(1)).save(testOwner)
    }

    @Test
    fun delete() {
        ownerSDJpaService.delete(testOwner)

        verify(ownerRepository, times(1)).delete(any())
    }

    @Test
    fun deleteById() {
        ownerSDJpaService.deleteById(ownerId)

        verify(ownerRepository, times(1)).deleteById(anyLong())
    }
}