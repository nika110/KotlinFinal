package com.example.imgzavredges.ui.trip.bottom_sheet_fragments

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.imgzavredges.R
import com.example.imgzavredges.databinding.FragmentLastRideBottomSheetBinding
import com.example.imgzavredges.ui.trip.inerface.BottomSheetCallBack
import com.example.imgzavredges.utils.*
import com.example.imgzavredges.utils.LastRideViewModels.costLastRideViewModel
import com.example.imgzavredges.utils.LastRideViewModels.distanceLastRideViewModel
import com.example.imgzavredges.utils.LastRideViewModels.ecologyLastRideViewModel
import com.example.imgzavredges.utils.LastRideViewModels.spentFuelLastRideViewModel
import com.example.imgzavredges.utils.LastRideViewModels.tripViewModel
import com.example.imgzavredges.utils.LastRideViewModels.remainsFuelViewModel
import java.util.*


class LastRideBottomSheetFragment(private val callBack: BottomSheetCallBack) : Fragment() {
    lateinit var binding: FragmentLastRideBottomSheetBinding
    lateinit var fuelStats: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var odometerValue = ""
    private var priceValue = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLastRideBottomSheetBinding.inflate(inflater, container, false)
        LastRideViewModels.initViewModelsLastRide(requireActivity())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fuelStats = requireContext().getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        editor = fuelStats.edit()
        binding.lastOdometerText.text =
            fuelStats.getFloat(ODOMETER, 0.0f).toString()
        initListeners()
    }

    private fun initListeners() {
        binding.submitBtnFuel.setOnClickListener {
            odometerValue = Objects.requireNonNull(binding.odometerText.text).toString()
            priceValue = Objects.requireNonNull(binding.priceText.text).toString()
            if (odometerValue.isNotEmpty() && priceValue.isNotEmpty()) {
                checkOdometerReadingsTwoFields(odometerValue.toFloat())
            } else if (odometerValue.isNotEmpty()) {
                checkOdometerReadingsOneField(odometerValue.toFloat())
            } else if (priceValue.isNotEmpty()) {
                binding.odometerEditText.error = getString(R.string.edit_text_odometer_error)
            } else
                callBack.dismissBottomSheet()
        }
    }

    private fun checkOdometerReadingsTwoFields(odometer: Float) {
        if (fuelStats.getFloat(ODOMETER, 0.0f) > odometer) {
            showDialogOdometerError()
        } else {
            editor.putFloat(ODOMETER, odometerValue.toFloat())
            editor.putFloat(COST_PER_LITER_LAST_RIDE, priceValue.toFloat())
            distanceLastRideViewModel.setDistanceLastRide(odometerValue.toFloat())
            costLastRideViewModel.setCostLastRide(priceValue.toFloat())
            editor.apply()
            callMethods()
            callBack.dismissBottomSheet()
        }
    }

    private fun checkOdometerReadingsOneField(odometer: Float) {
        if (fuelStats.getFloat(ODOMETER, 0.0f) > odometer) {
            showDialogOdometerError()
        } else {
            distanceLastRideViewModel.setDistanceLastRide(odometerValue.toFloat())
            editor.putFloat(ODOMETER, odometerValue.toFloat())
            editor.putFloat(COST_PER_LITER_LAST_RIDE, 0.0f)
            editor.putFloat(COST_LAST_RIDE, 0.0f)
            editor.apply()
            callMethods()
            callBack.dismissBottomSheet()
        }
    }

    private fun callMethods() {
        spentFuelLastRideViewModel.setSpentFuelLastRide()
        ecologyLastRideViewModel.setCarEmissions()
        tripViewModel.setFuelInTank()
        remainsFuelViewModel.setRemainsFuelNewRide()
    }

    private fun showDialogOdometerError() {
        val dialog =
            AlertDialog.Builder(requireContext()).setView(R.layout.dialog_odometer_error).create()
        dialog.show()
        dialog.window!!.setBackgroundDrawableResource(R.color.transparent)
        val okBtn = dialog.findViewById<Button>(R.id.ok_button)
        okBtn!!.setOnClickListener { dialog.dismiss() }
    }

}
