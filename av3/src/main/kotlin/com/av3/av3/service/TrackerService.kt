package com.av3.av3.service

import lombok.NoArgsConstructor

@NoArgsConstructor
interface TrackerService {
    fun calcularDistancia(): String;
}