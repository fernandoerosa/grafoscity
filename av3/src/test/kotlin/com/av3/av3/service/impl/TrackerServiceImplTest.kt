package com.av3.av3.service.impl

import City
import Edge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`

class TrackerServiceImplTest {

    @Test
    fun testCalculateShortestPath() {
        // Mock do grafo e arestas
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

        val trackerService = TrackerServiceImpl()

        val source = City("CityA")
        val destination = City("CityF")

        `when`(trackerService.buildPath(any(), any())).thenReturn(listOf(source, City("CityB"), City("CityD"), destination))

        val result = trackerService.calculateShortestPath(graph, edges, source, destination)

        assertEquals(listOf(source, City("CityB"), City("CityD"), destination), result)
    }
}