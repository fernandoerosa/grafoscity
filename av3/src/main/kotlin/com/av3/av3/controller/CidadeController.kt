package com.av3.av3.controller

import com.av3.av3.service.TrackerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/city")
class CidadeController @Autowired constructor(private val trackerService: TrackerService) {

    @GetMapping("/calcular-distancia")
    fun calcularDistancia(): List<String> {
        return listOf(trackerService.calcularDistancia(), trackerService.calcularDistancia())
    }
}
