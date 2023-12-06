package com.av3.av3.service.impl

import City
import Edge
import com.av3.av3.model.ConsumptionValue
import com.av3.av3.model.Vehicle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`

class TrackerServiceImplTest {

    @Test
    fun testCalculateShortestPath() {
        // Mock do grafo e arestas
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


        val vehicle = Vehicle(ConsumptionValue.CAR);

        val trackerService = TrackerServiceImpl()

        val source = City("Chapeco")
        val destination = City("Concordia")

        `when`(trackerService.buildPath(any(), any(), any(), any(), any(), any())).thenReturn(
            mapOf(
                "track" to listOf(City("Chapeco"), City("Maravilha"), City("Xanxere"), City("Concordia")).toString(),
                "kmValue" to 61.toString(),
                "tollValue" to 13.toString(),
                "fuelValue" to (vehicle.type.fuelValue * 61).toString(),
                "trackTime (h)" to 27.toString()
            )
        )

        val result = trackerService.calculateEdgeValues(graph, edges, source, destination, vehicle)

        assertEquals(listOf(source, City("CityB"), City("CityD"), destination), result)
    }
}