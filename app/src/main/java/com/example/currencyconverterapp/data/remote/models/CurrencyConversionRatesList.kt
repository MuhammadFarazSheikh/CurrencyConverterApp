package com.example.currencyconverterapp.data.remote.models

data class CurrencyConversionRatesList(
    val base:String="",
    val date:String="",
    val rates: Map<String, Double> = emptyMap()
)