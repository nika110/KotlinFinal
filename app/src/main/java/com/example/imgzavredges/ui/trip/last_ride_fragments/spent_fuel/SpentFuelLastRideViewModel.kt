package com.example.imgzavredges.ui.trip.last_ride_fragments.spent_fuel

import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imgzavredges.App
import com.example.imgzavredges.utils.APP_PREFERENCES
import com.example.imgzavredges.utils.SPENT_FUEL_LAST_RIDE
import com.example.imgzavredges.utils.SharedPreferencesHolder

class SpentFuelLastRideViewModel: ViewModel() {
    private val spentFuelLastRide = MutableLiveData<String>()
    private val fuelStats = App.instance.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

    init {
        setDefaultSpentFuel()
    }

    private fun setDefaultSpentFuel(){
        spentFuelLastRide.postValue(fuelStats.getFloat(SPENT_FUEL_LAST_RIDE, 0.0f).toString())
    }

    fun setSpentFuelLastRide(){
        spentFuelLastRide.postValue(SharedPreferencesHolder.countSpentFuelLastRide().toString())
    }

    fun getSpentFuelLastRide(): LiveData<String> {
        return spentFuelLastRide
    }
}