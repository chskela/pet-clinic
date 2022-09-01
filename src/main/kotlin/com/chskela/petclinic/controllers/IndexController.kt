package com.chskela.petclinic.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController {

    @RequestMapping(*arrayOf("", "/", "index", "index.html"))
    fun index() = "index"
}