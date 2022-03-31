package com.manueldevmx.sunnyrainy_mvvm.network.service

import com.manueldevmx.sunnyrainy_mvvm.mainModule.model.OneCall
import com.manueldevmx.sunnyrainy_mvvm.network.api.RetrofitInstance
import com.manueldevmx.sunnyrainy_mvvm.network.api.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class GetWeather() {

    //Se instancia el servicio de retrofit con la peticion de LogIn
    private val retrofit = RetrofitInstance.RetrofitInstance.getRetrofit().create(Weather::class.java)

    //Se crea la funcion para mandar la peticion con los parametros necesarios para realizarla
    //Con un tipo de retorno del modelo de la respuesta
    suspend fun getWeatherService(lat: String, lon: String, units: String?, lang: String?, appid: String): Response<OneCall> {
        return withContext(Dispatchers.IO){
            val response = retrofit.getWeatherByLoc(lat, lon, units, lang, appid)
            response
        }
    }

}