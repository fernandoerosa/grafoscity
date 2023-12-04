package com.av3.av3.service.impl

import com.av3.av3.model.CidadeModel
import com.av3.av3.service.TrackerService
import org.springframework.stereotype.Service
import java.util.Collections
import java.util.PriorityQueue
import java.util.Queue

@Service
class TrackerServiceImpl: TrackerService  {

    override fun calcularDistanciaMaisCurta(cidade: CidadeModel) {
        cidade.distancia = 0;
        val cidadesOcupadas: MutableSet<CidadeModel>;
        val cidadesDesocupadas: Queue<CidadeModel> = PriorityQueue(Collections.singleton(cidade));
        while(!cidadesDesocupadas.isEmpty()) {
            val cidadeAtual: CidadeModel = cidadesDesocupadas.poll();
            cidadeAtual.cidadesAdjacente
                .entries
        }

    }

}