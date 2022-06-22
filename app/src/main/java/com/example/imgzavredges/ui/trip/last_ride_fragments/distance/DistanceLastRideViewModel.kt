package com.example.imgzavredges.ui.trip.last_ride_fragments.distance

import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imgzavredges.App
import com.example.imgzavredges.utils.APP_PREFERENCES
import com.example.imgzavredges.utils.DISTANCE_LAST_RIDE
import com.example.imgzavredges.utils.SharedPreferencesHolder

class DistanceLastRideViewModel: ViewModel() {
    private val distanceLastRide = MutableLiveData<String>()
    private val fuelStats = App.instance.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
    init {
        setDefaultDistance()
    }
    private fun setDefaultDistance(){
        distanceLastRide.postValue(fuelStats.getFloat(DISTANCE_LAST_RIDE, 0.0f).toString())
    }

    fun setDistanceLastRide(odometerValue: Float){
        val oldOdometerValue = SharedPreferencesHolder.oldOdometerValue()
        distanceLastRide.postValue(SharedPreferencesHolder.distance(oldOdometerValue, odometerValue).toString())
    }

    fun getDistanceLastRide(): LiveData<String> {
        return distanceLastRide
    }
}