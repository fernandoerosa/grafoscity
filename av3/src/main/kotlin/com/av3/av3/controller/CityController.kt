package com.av3.av3.controller

import City
import Edge
import com.av3.av3.service.TrackerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/city")
class CityController @Autowired constructor(private val trackerService: TrackerService) {

    @GetMapping("/calc")
    fun getShortestPath(
        @RequestParam source: String,
        @RequestParam destination: String
    ): List<City> {
        val graph = listOf(
            City("CityA"),
            City("CityB"),
            City("CityC"),
            City("CityD"),
            City("CityE"),
            City("CityF")
        )

        val edges = listOf(
            Edge(City("CityA"), City("CityB"), 1),
            Edge(City("CityA"), City("CityC"), 3),
            Edge(City("CityB"), City("CityD"), 2),
            Edge(City("CityB"), City("CityE"), 4),
            Edge(City("CityC"), City("CityE"), 1),
            Edge(City("CityD"), City("CityF"), 3),
            Edge(City("CityE"), City("CityF"), 2)
        )

        val sourceCity = graph.find { it.name == source }
            ?: throw IllegalArgumentException("City not found: $source")

        val destinationCity = graph.find { it.name == destination }
            ?: throw IllegalArgumentException("City not found: $destination")

        return trackerService.calculateShortestPath(graph, edges, sourceCity, destinationCity)
    }
}