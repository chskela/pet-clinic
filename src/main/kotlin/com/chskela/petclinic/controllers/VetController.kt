package com.chskela.petclinic.controllers

import com.chskela.petclinic.services.VetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/vets")
@Controller
class VetController(private val vetService: VetService) {

    @RequestMapping(*arrayOf("", "/", "/index", "/index.html"))
    fun listVets(model: Model): String {
        model.addAttribute("vets", vetService.findAll())
        return "vets/index"
    }
}