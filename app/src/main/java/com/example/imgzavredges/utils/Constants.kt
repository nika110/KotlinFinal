package com.example.imgzavredges.utils

import com.example.imgzavredges.ui.notes.database.repository.NoteRepository

const val APP_PREFERENCES = "fuelStats"
const val USERNAME = "username"
const val CONSUMPTION_PER_100KM = "consumptionPer100km"
const val FUEL_TANK_CAPACITY = "fuel_tank_capacity"
const val FUEL_TANK_CAPACITY_OLD = "fuel_tank_capacity_old"
const val DISTANCE_NEW_RIDE = "new_ride_distance"
const val COST_NEW_RIDE = "new_ride_cost"
const val WILL_BE_USED_FUEL = "will_be_used_fuel"
const val GASOLINE_EMISSIONS_NEW_RIDE = "new_ride_gasoline_emissions"
const val DIESEL_EMISSIONS_NEW_RIDE = "new_ride_diesel_emissions"
const val FUEL_LEVEL = "fuel_level"
const val REMAINS_FUEL = "remains_fuel"
const val ODOMETER = "odometer"
const val ODOMETER_OLD = "odometer_old"
const val DISTANCE_LAST_RIDE = "distance_last_ride"
const val COST_LAST_RIDE = "cost_last_ride"
const val SPENT_FUEL_LAST_RIDE = "spent_fuel_last_ride"
const val GASOLINE_EMISSIONS_LAST_RIDE = "gasoline_emissions_last_ride"
const val DIESEL_EMISSIONS_LAST_RIDE = "diesel_emissions_last_ride"
const val COST_PER_LITER_LAST_RIDE = "cost_per_liter_last_ride"
const val COST_PER_LITER_NEW_RIDE = "cost_per_liter_new_ride"
const val USER_CITY = "user_city"
const val IS_FIRST_LAUNCHED_DASHBOARD = "is_first_launched_dashboard"
const val IS_FIRST_LAUNCHED_CHANGE_DATA = "is_first_launched_change_data"
const val IS_FIRST_LAUNCHED_FUEL_MANAGEMENT = "is_first_launched_fuel_management"
const val co2EmissionPer1LiterOfGasoline = 2.347f
const val co2EmissionPer1LiterOfDiesel = 2.689f
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
const val KEY = "a98ca7720a8fd711bb8548bf2373e263"
const val MIN_SCALE = 0.85f
lateinit var REPOSITORY: NoteRepository
