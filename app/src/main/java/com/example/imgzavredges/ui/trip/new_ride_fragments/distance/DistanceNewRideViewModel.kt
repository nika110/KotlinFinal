package com.example.imgzavredges.ui.trip.new_ride_fragments.distance

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imgzavredges.App
import com.example.imgzavredges.utils.APP_PREFERENCES
import com.example.imgzavredges.utils.DISTANCE_NEW_RIDE

class DistanceNewRideViewModel: ViewModel() {
    private val distanceNewRide = MutableLiveData<String>()
    private val fuelStats = App.instance.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

    init {
        setDefaultDistance()
    }

    private fun setDefaultDistance(){
        distanceNewRide.postValue(fuelStats.getFloat(DISTANCE_NEW_RIDE, 0.0f).toString())
    }
    fun setDistanceNewRide(distance: Float){
        distanceNewRide.postValue(distance.toString())
    }

    fun getDistanceNewRide(): LiveData<String> {
        return distanceNewRide
    }
}