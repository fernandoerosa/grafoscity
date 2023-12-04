package com.av3.av3.model

import lombok.Getter
import lombok.RequiredArgsConstructor
import lombok.Setter
import java.util.HashMap
import java.util.LinkedList

@Getter
@Setter
@RequiredArgsConstructor
class CidadeModel: Comparable<CidadeModel>{

    //Entender melhor lateinit
    private final lateinit var nome: String;
    private var distancia: Int = Integer.MAX_VALUE;
    private var maisProximo: MutableList<CidadeModel> = LinkedList();
    private var cidadesAdjacente: MutableMap<CidadeModel, Int> = HashMap();

    fun adicionarCidadeAdjacente(cidade: CidadeModel, peso: Int) {
        cidadesAdjacente.put(cidade, peso);
    }

    override fun compareTo(other: CidadeModel): Int {
        return compareValues(
            this.distancia, other.distancia);
    }
}