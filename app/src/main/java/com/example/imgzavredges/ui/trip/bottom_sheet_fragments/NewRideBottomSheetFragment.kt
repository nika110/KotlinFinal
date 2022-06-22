package com.example.imgzavredges.ui.trip.bottom_sheet_fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imgzavredges.R
import com.example.imgzavredges.databinding.FragmentNewRideBottomSheetBinding
import com.example.imgzavredges.ui.trip.inerface.BottomSheetCallBack
import com.example.imgzavredges.utils.*
import com.example.imgzavredges.utils.NewRideViewModels.costNewRideViewModel
import com.example.imgzavredges.utils.NewRideViewModels.distanceNewRideViewModel
import com.example.imgzavredges.utils.NewRideViewModels.ecologyNewRideViewModel
import com.example.imgzavredges.utils.NewRideViewModels.remainsFuelNewRideViewModel
import com.example.imgzavredges.utils.NewRideViewModels.spendFuelNewRideViewModel

class NewRideBottomSheetFragment(private val callBack: BottomSheetCallBack) : Fragment() {
    private lateinit var binding: FragmentNewRideBottomSheetBinding
    private lateinit var fuelStats: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewRideBottomSheetBinding.inflate(inflater, container, false)
        NewRideViewModels.initViewModelsNewRide(requireActivity())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fuelStats = requireContext().getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        editor = fuelStats.edit()
        binding.submitBtnFuel.setOnClickListener {
            val distance = binding.distanceNewRideText.text.toString()
            val price = binding.priceNewRideText.text.toString()
            if (distance.isNotEmpty() && price.isNotEmpty()) {
                editor.putFloat(DISTANCE_NEW_RIDE, distance.toFloat())
                editor.putFloat(COST_PER_LITER_NEW_RIDE, price.toFloat())
                editor.apply()
                distanceNewRideViewModel.setDistanceNewRide(distance.toFloat())
                costNewRideViewModel.setCostNewRide(price.toFloat())
                callMethods()
                callBack.dismissBottomSheet()
            } else if (distance.isNotEmpty()) {
                editor.putFloat(DISTANCE_NEW_RIDE, distance.toFloat())
                editor.putFloat(COST_PER_LITER_NEW_RIDE, 0.0f)
                editor.putFloat(COST_NEW_RIDE, 0.0f)
                editor.apply()
                distanceNewRideViewModel.setDistanceNewRide(distance.toFloat())
                callMethods()
                callBack.dismissBottomSheet()
            } else if (price.isNotEmpty()) {
                binding.distanceNewRideEditText.error = getString(R.string.edit_text_odometer_error)
            } else
                callBack.dismissBottomSheet()
        }
    }

    private fun callMethods() {
        spendFuelNewRideViewModel.setSpendFuelNewRide()
        ecologyNewRideViewModel.setCarEmissions()
        remainsFuelNewRideViewModel.setRemainsFuelNewRide()
    }


}