package com.av3.av3.service.impl

import com.av3.av3.service.TrackerService
import org.springframework.stereotype.Service

@Service
class TrackerServiceImpl : TrackerService  {

    override fun calcularDistancia(): String {
        return "retornado"
    }

}