package com.av3.av3.controller

import CidadeModel
import EdgeModel
import com.av3.av3.service.TrackerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/city")
class CidadeController @Autowired constructor(private val trackerService: TrackerService) {

    @GetMapping("/calc")
    fun getShortestPath(
        @RequestParam source: String,
        @RequestParam destination: String
    ): List<CidadeModel> {
        val graph = listOf(
            CidadeModel("CityA"),
            CidadeModel("CityB"),
            CidadeModel("CityC"),
            CidadeModel("CityD"),
            CidadeModel("CityE"),
            CidadeModel("CityF")
        )

        val edges = listOf(
            EdgeModel(CidadeModel("CityA"), CidadeModel("CityB"), 1),
            EdgeModel(CidadeModel("CityA"), CidadeModel("CityC"), 3),
            EdgeModel(CidadeModel("CityB"), CidadeModel("CityD"), 2),
            EdgeModel(CidadeModel("CityB"), CidadeModel("CityE"), 4),
            EdgeModel(CidadeModel("CityC"), CidadeModel("CityE"), 1),
            EdgeModel(CidadeModel("CityD"), CidadeModel("CityF"), 3),
            EdgeModel(CidadeModel("CityE"), CidadeModel("CityF"), 2)
        )

        val sourceCity = graph.find { it.name == source }
            ?: throw IllegalArgumentException("City not found: $source")

        val destinationCity = graph.find { it.name == destination }
            ?: throw IllegalArgumentException("City not found: $destination")

        return trackerService.calculateShortestPath(graph, edges, sourceCity, destinationCity)
    }
}
