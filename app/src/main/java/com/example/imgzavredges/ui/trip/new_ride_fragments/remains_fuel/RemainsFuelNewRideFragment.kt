package com.example.imgzavredges.ui.trip.new_ride_fragments.remains_fuel

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.imgzavredges.R
import com.example.imgzavredges.databinding.FragmentFuelInTankNewRideBinding

class RemainsFuelNewRideFragment: Fragment() {
    lateinit var binding: FragmentFuelInTankNewRideBinding
    private lateinit var remainsFuelNewRideViewModel: RemainsFuelNewRideViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFuelInTankNewRideBinding.inflate(inflater, container, false)
        remainsFuelNewRideViewModel = ViewModelProvider(requireActivity())[RemainsFuelNewRideViewModel::class.java]
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        remainsFuelNewRideViewModel.getRemainsFuelNewRide().observe(viewLifecycleOwner) {
            if (it.toFloat() > 0.0f) {
                binding.remainsInTheTankCount.text = "$it ${getString(R.string.litres_symbol)}"
                binding.remainsInTheTankCount.setTextColor(requireContext().getColor(R.color.white))
            } else{
                binding.remainsInTheTankCount.text = "$it ${getString(R.string.litres_symbol)}"
                binding.remainsInTheTankCount.setTextColor(requireContext().getColor(R.color.red))
            }

        }
    }
}