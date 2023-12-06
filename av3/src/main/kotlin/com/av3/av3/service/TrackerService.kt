package com.av3.av3.service

import City
import Edge
import com.av3.av3.model.Vehicle
import lombok.NoArgsConstructor

@NoArgsConstructor
interface TrackerService {
    fun calculateEdgeValues(
        graph: List<City>,
        edges: List<Edge>,
        source: City,
        destination: City,
        vehicle: Vehicle
    ): Map<String, String>
}