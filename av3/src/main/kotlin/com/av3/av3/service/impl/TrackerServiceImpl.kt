package com.av3.av3.service.impl

import CidadeModel
import EdgeModel
import com.av3.av3.service.TrackerService
import org.springframework.stereotype.Service

@Service
class TrackerServiceImpl : TrackerService  {

    override fun calculateShortestPath(graph: List<CidadeModel>, edges: List<EdgeModel>, source: CidadeModel, destination: CidadeModel): List<CidadeModel> {
        val graphMap = edges.groupBy { it.source }.mapValues { it.value.associateBy { edge -> edge.destination } }
        val distances = mutableMapOf<CidadeModel, Int>().apply { put(source, 0) }
        val previous = mutableMapOf<CidadeModel, CidadeModel?>()
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

    private fun buildPath(previous: Map<CidadeModel, CidadeModel?>, destination: CidadeModel): List<CidadeModel> {
        val path = mutableListOf<CidadeModel>()
        var current: CidadeModel? = destination
        while (current != null) {
            path.add(current)
            current = previous[current]
        }
        return path.reversed()
    }
}