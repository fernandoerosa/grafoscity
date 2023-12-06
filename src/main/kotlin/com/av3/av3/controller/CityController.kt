package com.av3.av3.controller

import City
import Edge
import com.av3.av3.model.ConsumptionValue
import com.av3.av3.model.Vehicle
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
        @RequestParam destination: String,
        @RequestParam vehicleCode: String
    ): Map<String, String> {
        val graph = listOf(
            City("Chapecó"),
            City("São Miguel do Oeste"),
            City("Xanxerê"),
            City("Concordia"),
            City("Maravilha")
        )

        val edges = listOf(
            Edge(City("Chapecó"), City("São Miguel do Oeste"), 5, 5, 10),
            Edge(City("Chapecó"), City("Maravilha"), 4, 2, 7),
            Edge(City("Chapecó"), City("Xanxerê"), 3, 1, 3),
            Edge(City("Chapecó"), City("Concordia"), 4, 1, 5),
            Edge(City("São Miguel do Oeste"), City("Maravilha"), 1, 0, 4),
            Edge(City("Maravilha"), City("Xanxerê"), 3, 1, 4),
            Edge(City("Xanxerê"), City("Concordia"), 4, 5, 6),
        )

        val vehicle = ConsumptionValue.getByCode(vehicleCode)?.let { Vehicle(it) }
            ?: throw IllegalArgumentException("Vehicle not found? $vehicleCode")

        val sourceCity = graph.find { it.name == source }
            ?: throw IllegalArgumentException("City not found: $source")

        val destinationCity = graph.find { it.name == destination }
            ?: throw IllegalArgumentException("City not found: $destination")

        return trackerService.calculateEdgeValues(graph, edges, sourceCity, destinationCity, vehicle)
    }
}
