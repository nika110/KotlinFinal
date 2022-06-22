package com.example.imgzavredges.ui.trip.last_ride_fragments.ecology

import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imgzavredges.App
import com.example.imgzavredges.utils.APP_PREFERENCES
import com.example.imgzavredges.utils.DIESEL_EMISSIONS_LAST_RIDE
import com.example.imgzavredges.utils.GASOLINE_EMISSIONS_LAST_RIDE
import com.example.imgzavredges.utils.SharedPreferencesHolder

class EcologyLastRideViewModel: ViewModel() {
    private val dieselEmissions = MutableLiveData<String>()
    private val gasolineEmissions = MutableLiveData<String>()
    private val fuelStats = App.instance.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    init {
        setDefaultCarEmissions()
    }
    private fun setDefaultCarEmissions(){
        dieselEmissions.postValue(fuelStats.getFloat(DIESEL_EMISSIONS_LAST_RIDE, 0.0f).toString())
        gasolineEmissions.postValue(fuelStats.getFloat(GASOLINE_EMISSIONS_LAST_RIDE, 0.0f).toString())
    }

    fun setCarEmissions(){
        dieselEmissions.postValue(SharedPreferencesHolder.co2DieselEmissionLastRide().toString())
        gasolineEmissions.postValue(SharedPreferencesHolder.co2GasolineEmissionLastRide().toString())
    }

    fun getGasolineEmissions(): LiveData<String>{
        return gasolineEmissions
    }

    fun getDieselEmissions(): LiveData<String>{
        return dieselEmissions
    }
}