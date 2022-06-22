package com.example.imgzavredges.ui.trip.new_ride_fragments.cost

import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imgzavredges.App
import com.example.imgzavredges.utils.APP_PREFERENCES
import com.example.imgzavredges.utils.COST_NEW_RIDE
import com.example.imgzavredges.utils.SharedPreferencesHolder

class CostNewRideViewModel: ViewModel() {
    private val costNewRide = MutableLiveData<String>()
    private val fuelStats = App.instance.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)

    init {
        setDefaultCost()
    }

    private fun setDefaultCost(){
        costNewRide.postValue(fuelStats.getFloat(COST_NEW_RIDE, 0.0f).toString())
    }

    fun setCostNewRide(cost: Float){
        costNewRide.postValue(SharedPreferencesHolder.priceNewRide(cost).toString())
    }

    fun getCostNewRide(): LiveData<String> {
        return costNewRide
    }
}