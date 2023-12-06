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
            City("Chapeco"),
            City("Sao Miguel do Oeste"),
            City("Xanxere"),
            City("Concordia"),
            City("Maravilha")
        )

        val edges = listOf(
            Edge(City("Chapeco"), City("Sao Miguel do Oeste"), 10, 5, 10),
            Edge(City("Chapeco"), City("Maravilha"), 4, 2, 7),
            Edge(City("Sao Miguel do Oeste"), City("Maravilha"), 40, 0, 4),
            Edge(City("Maravilha"), City("Xanxere"), 14, 1, 4),
            Edge(City("Xanxere"), City("Concordia"), 33, 5, 6),
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
