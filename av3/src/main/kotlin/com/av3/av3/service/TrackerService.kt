package com.av3.av3.service

import City
import Edge
import lombok.NoArgsConstructor

@NoArgsConstructor
interface TrackerService {
    fun calculateShortestPath(graph: List<City>, edges: List<Edge>, source: City, destination: City): List<City>;
}