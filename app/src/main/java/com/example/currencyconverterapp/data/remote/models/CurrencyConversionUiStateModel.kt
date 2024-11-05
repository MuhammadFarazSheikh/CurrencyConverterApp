package com.example.currencyconverterapp.data.remote.models

data class CurrencyConversionUiStateModel(
    var isShowLoader:Boolean=false,
    var isFailed:Boolean=false,
    val base:String="",
    val date:String="",
    val rates: Map<String, Double> = emptyMap()
)