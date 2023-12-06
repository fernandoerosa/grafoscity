package com.av3.av3.service.impl

import City
import Edge
import com.av3.av3.model.Vehicle
import com.av3.av3.service.TrackerService
import org.springframework.stereotype.Service

@Service
class TrackerServiceImpl : TrackerService {

    override fun calculateEdgeValues(
        graph: List<City>,
        edges: List<Edge>,
        source: City,
        destination: City,
        vehicle: Vehicle
    ): Map<String, String> {
        val graphMap = edges.groupBy { it.source }.mapValues { it.value.associateBy { edge -> edge.destination } }
        val distances = mutableMapOf<City, Int>().apply { put(source, 0) }
        val previous = mutableMapOf<City, City?>()
        val unvisited = HashSet(graph)

        var kmValue = 0
        var tollValue = 0
        var trackTime = 0
        while (unvisited.isNotEmpty()) {
            val current = unvisited.minByOrNull { distances.getOrDefault(it, Int.MAX_VALUE) } ?: break
            unvisited.remove(current)
            for ((neighbor, edge) in graphMap.getOrDefault(current, emptyMap())) {
                val alt = distances[current]!! + edge.weight
                if (alt < distances.getOrDefault(neighbor, Int.MAX_VALUE)) {
                    kmValue += edge.weight
                    tollValue += edge.tollValue
                    trackTime += edge.trackTime
                    distances[neighbor] = alt
                    previous[neighbor] = current
                }
            }
        }

        return buildPath(previous, destination, kmValue, tollValue, vehicle, trackTime)
    }

    internal fun buildPath(
        previous: Map<City, City?>,
        destination: City,
        kmValue: Int,
        tollValue: Int,
        vehicle: Vehicle,
        trackTime: Int
    ): Map<String, String> {
        val path = mutableListOf<City>()
        var current: City? = destination
        while (current != null) {
            path.add(current)
            current = previous[current]
        }

        return mapOf(
            "track" to path.reversed().toString(),
            "kmValue" to kmValue.toString(),
            "tollValue" to tollValue.toString(),
            "fuelValue" to (vehicle.type.fuelValue * kmValue).toString(),
            "trackTime (h)" to trackTime.toString()
        )
    }
}