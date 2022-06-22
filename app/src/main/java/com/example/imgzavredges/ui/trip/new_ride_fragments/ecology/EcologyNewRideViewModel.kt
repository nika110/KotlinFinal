package com.example.imgzavredges.ui.trip.new_ride_fragments.ecology

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imgzavredges.App
import com.example.imgzavredges.utils.APP_PREFERENCES
import com.example.imgzavredges.utils.DIESEL_EMISSIONS_NEW_RIDE
import com.example.imgzavredges.utils.GASOLINE_EMISSIONS_NEW_RIDE
import com.example.imgzavredges.utils.SharedPreferencesHolder

class EcologyNewRideViewModel: ViewModel() {
    private val dieselEmissions = MutableLiveData<String>()
    private val gasolineEmissions = MutableLiveData<String>()
    private val fuelStats = App.instance.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    init {
        setDefaultEmissions()
    }

    private fun setDefaultEmissions(){
        dieselEmissions.postValue(fuelStats.getFloat(DIESEL_EMISSIONS_NEW_RIDE, 0.0f).toString())
        gasolineEmissions.postValue(fuelStats.getFloat(GASOLINE_EMISSIONS_NEW_RIDE, 0.0f).toString())
    }
    fun setCarEmissions(){
        dieselEmissions.postValue(SharedPreferencesHolder.co2DieselEmissionNewRide().toString())
        gasolineEmissions.postValue(SharedPreferencesHolder.co2GasolineEmissionNewRide().toString())
    }

    fun getGasolineEmissions(): LiveData<String> {
        return gasolineEmissions
    }

    fun getDieselEmissions(): LiveData<String> {
        return dieselEmissions
    }
}