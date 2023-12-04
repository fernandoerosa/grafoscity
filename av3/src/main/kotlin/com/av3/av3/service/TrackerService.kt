package com.av3.av3.service

import com.av3.av3.model.CidadeModel
import lombok.NoArgsConstructor

@NoArgsConstructor
interface TrackerService {
    fun calcularDistanciaMaisCurta(cidade: CidadeModel);

}