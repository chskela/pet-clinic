package com.chskela.petclinic.controllers

import com.chskela.petclinic.services.OwnerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/owners")
@Controller
class OwnerController(private val ownerService: OwnerService) {

    @RequestMapping("", "/", "/index", "/index.html")
    fun listOwners(model: Model): String {
        model.addAttribute("owners", ownerService.findAll())
        return "owners/index"
    }

    @RequestMapping("/find")
    fun findOwners(): String {
        return "notimplemented"
    }
}