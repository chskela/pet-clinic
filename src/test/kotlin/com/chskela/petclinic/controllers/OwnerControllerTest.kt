package com.chskela.petclinic.controllers

import com.chskela.petclinic.model.Owner
import com.chskela.petclinic.services.OwnerService
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verifyNoInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
internal class OwnerControllerTest {

    @Mock
    lateinit var ownerService: OwnerService


    @InjectMocks
    lateinit var ownerController: OwnerController

    private lateinit var owners: Set<Owner>

    private lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setUp() {
        owners = setOf(Owner.notFound().copy(id = 1L), Owner.notFound().copy(id = 2L))

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build()
    }

    @Test
    fun listOwners() {
        `when`(ownerService.findAll()).thenReturn(owners)

        mockMvc.perform(get("/owners"))
            .andExpect(status().isOk)
            .andExpect(view().name("owners/index"))
            .andExpect(model().attribute("owners", hasSize<Owner>(2)))
    }

    @Test
    fun listOwnersByIndex() {
        `when`(ownerService.findAll()).thenReturn(owners)

        mockMvc.perform(get("/owners/index"))
            .andExpect(status().isOk)
            .andExpect(view().name("owners/index"))
            .andExpect(model().attribute("owners", hasSize<Owner>(2)))
    }

    @Test
    fun findOwners() {
        mockMvc.perform(get("/owners/find"))
            .andExpect(status().isOk)
            .andExpect(view().name("notimplemented"))

        verifyNoInteractions(ownerService)
    }
}