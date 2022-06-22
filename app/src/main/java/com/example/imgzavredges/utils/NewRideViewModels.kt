package com.example.imgzavredges.utils

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.imgzavredges.ui.trip.TripViewModel
import com.example.imgzavredges.ui.trip.new_ride_fragments.cost.CostNewRideViewModel
import com.example.imgzavredges.ui.trip.new_ride_fragments.distance.DistanceNewRideViewModel
import com.example.imgzavredges.ui.trip.new_ride_fragments.ecology.EcologyNewRideViewModel
import com.example.imgzavredges.ui.trip.new_ride_fragments.remains_fuel.RemainsFuelNewRideViewModel
import com.example.imgzavredges.ui.trip.new_ride_fragments.spendFuel.SpendFuelNewRideViewModel

object NewRideViewModels {
    private lateinit var tripViewModel: TripViewModel
    lateinit var remainsFuelNewRideViewModel: RemainsFuelNewRideViewModel
    lateinit var costNewRideViewModel: CostNewRideViewModel
    lateinit var distanceNewRideViewModel: DistanceNewRideViewModel
    lateinit var ecologyNewRideViewModel: EcologyNewRideViewModel
    lateinit var spendFuelNewRideViewModel: SpendFuelNewRideViewModel

    fun initViewModelsNewRide(fragmentActivity: FragmentActivity) {
        tripViewModel = ViewModelProvider(fragmentActivity)[TripViewModel::class.java]
        remainsFuelNewRideViewModel =
            ViewModelProvider(fragmentActivity)[RemainsFuelNewRideViewModel::class.java]
        distanceNewRideViewModel =
            ViewModelProvider(fragmentActivity)[DistanceNewRideViewModel::class.java]
        ecologyNewRideViewModel =
            ViewModelProvider(fragmentActivity)[EcologyNewRideViewModel::class.java]
        remainsFuelNewRideViewModel =
            ViewModelProvider(fragmentActivity)[RemainsFuelNewRideViewModel::class.java]
        spendFuelNewRideViewModel =
            ViewModelProvider(fragmentActivity)[SpendFuelNewRideViewModel::class.java]
        costNewRideViewModel = ViewModelProvider(fragmentActivity)[CostNewRideViewModel::class.java]
    }
}