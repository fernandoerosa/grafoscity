package com.av3.av3.model

data class Vehicle(val type: ConsumptionValue) {
}

enum class ConsumptionValue(val code: String, val fuelValue: Int) {
    MOTORCYCLE("M", 1),
    CAR("C", 3),
    MINIBUS("MI", 5),
    BUS("B", 7),
    TRUCK("T", 8);

    companion object {
        fun getByCode(code: String): ConsumptionValue? {
            return values().find { it.code == code }
        }
    }
}