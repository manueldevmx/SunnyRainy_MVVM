package com.manueldevmx.sunnyrainy_mvvm.network.service

import com.manueldevmx.sunnyrainy_mvvm.mainModule.model.CityEntity
import com.manueldevmx.sunnyrainy_mvvm.network.api.City
import com.manueldevmx.sunnyrainy_mvvm.network.api.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class GetCity {

    //Se instancia el servicio de retrofit con la peticion de la Ciudad
    private val retrofit = RetrofitInstance.RetrofitInstance.getRetrofit().create(City::class.java)

    //Se crea la funcion para mandar la peticion con los parametros necesarios para realizarla
    //Con un tipo de retorno del modelo de la respuesta
    suspend fun getCityService(lat: String, lon: String, appid: String): Response<List<CityEntity>> {
        return withContext(Dispatchers.IO){
            val response = retrofit.getCitiesByLatLng(lat, lon, appid)
            response
        }
    }

}