package com.manueldevmx.sunnyrainy_mvvm.mainModule.model

import java.io.Serializable

data class Main(
    val temp: Double,
    val feels_like: Double,
    val temp_max: Double,
    val temp_min: Double,
    val pressure: Int,
    val humidity: Int,
): Serializable
