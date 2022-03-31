package com.manueldevmx.sunnyrainy_mvvm.mainModule.viewModel

import androidx.core.view.isVisible
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manueldevmx.sunnyrainy_mvvm.databinding.ActivityMainBinding
import com.manueldevmx.sunnyrainy_mvvm.mainModule.model.CityEntity
import com.manueldevmx.sunnyrainy_mvvm.mainModule.model.OneCall
import com.manueldevmx.sunnyrainy_mvvm.network.service.GetCity
import com.manueldevmx.sunnyrainy_mvvm.network.service.GetWeather
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {

    //Service
    lateinit var serviceGetWeather: GetWeather
    lateinit var serviceGetCity: GetCity

    //LiveDatas
    val getWeatherResponse = MutableLiveData<OneCall>()
    val getCityResponse = MutableLiveData<List<CityEntity>>()

    private lateinit var binding: ActivityMainBinding

    fun onCreate(){
        serviceGetWeather = GetWeather()
        serviceGetCity = GetCity()
    }

    //Funcion
    fun getWeather(lat: String, lon: String, units: String?, lang: String?, appid: String){
        viewModelScope.launch {
            val response = serviceGetWeather.getWeatherService(lat, lon, units, lang, appid)
            if (response.isSuccessful){
                getWeatherResponse.postValue(response.body())
            }else {
                binding.errorContainer.isVisible = true
            }
        }
    }

    fun getCity(lat: String, lon:String, appid: String){
        viewModelScope.launch {
            val response = serviceGetCity.getCityService(lat, lon, appid)
            if (response.isSuccessful){
                getCityResponse.postValue(response.body())
            }else{
                binding.errorContainer.isVisible = true
            }
        }
    }

}