package com.av3.av3.service.impl

import City
import Edge
import com.av3.av3.service.TrackerService
import org.springframework.stereotype.Service

@Service
class TrackerServiceImpl : TrackerService  {

    override fun calculateShortestPath(graph: List<City>, edges: List<Edge>, source: City, destination: City): List<City> {
        val graphMap = edges.groupBy { it.source }.mapValues { it.value.associateBy { edge -> edge.destination } }
        val distances = mutableMapOf<City, Int>().apply { put(source, 0) }
        val previous = mutableMapOf<City, City?>()
        val unvisited = HashSet(graph)

        while (unvisited.isNotEmpty()) {
            val current = unvisited.minByOrNull { distances.getOrDefault(it, Int.MAX_VALUE) } ?: break
            unvisited.remove(current)

            for ((neighbor, edge) in graphMap.getOrDefault(current, emptyMap())) {
                val alt = distances[current]!! + edge.weight
                if (alt < distances.getOrDefault(neighbor, Int.MAX_VALUE)) {
                    distances[neighbor] = alt
                    previous[neighbor] = current
                }
            }
        }

        return buildPath(previous, destination)
    }

    internal fun buildPath(previous: Map<City, City?>, destination: City): List<City> {
        val path = mutableListOf<City>()
        var current: City? = destination
        while (current != null) {
            path.add(current)
            current = previous[current]
        }
        return path.reversed()
    }
}