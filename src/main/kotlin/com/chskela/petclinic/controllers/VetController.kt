package com.chskela.petclinic.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/vets")
@Controller
class VetController {

    @RequestMapping(*arrayOf("", "/", "/index", "/index.html"))
    fun listVets() = "vets/index"
}