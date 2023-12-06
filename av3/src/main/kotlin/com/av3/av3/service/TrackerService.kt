package com.av3.av3.service

import CidadeModel
import EdgeModel
import lombok.NoArgsConstructor

@NoArgsConstructor
interface TrackerService {
    fun calculateShortestPath(graph: List<CidadeModel>, edges: List<EdgeModel>, source: CidadeModel, destination: CidadeModel): List<CidadeModel>;
}