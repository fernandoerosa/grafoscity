package com.av3.av3.model

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import lombok.Setter
import java.util.HashMap
import java.util.LinkedList
import kotlin.collections.HashMap

@Getter
@Setter
@RequiredArgsConstructor
class CidadeModel: Comparable<CidadeModel>{

    //Entender melhor lateinit
    private final lateinit var nome: String;
    private var distancia: Int = Integer.MAX_VALUE;
    //TODO: Verificar valor de LinkedList
    private var maisProximo: List<CidadeModel> = LinkedList<CidadeModel>();
    //TODO: Verificar o tipo(MutableMapOf ou Map?)
    private var cidadesAdjacente: Map<CidadeModel, Int> = mutableMapOf<CidadeModel, Int>();

    //TODO: Implementar
    fun adicionarCidadeAdjacente(cidade: CidadeModel, peso: Int) {
        cidadesAdjacente.
    }

    override fun compareTo(outraCidade: CidadeModel): Int {
        return compareValues(
            this.distancia, outraCidade.distancia);
    }
}