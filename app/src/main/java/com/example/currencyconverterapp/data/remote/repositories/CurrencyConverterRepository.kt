package com.example.currencyconverterapp.data.remote.repositories

import com.example.currencyconverterapp.CURRENY_EXCHANGE_RATES_API
import com.example.currencyconverterapp.data.remote.models.CurrencyConversionRatesList
import retrofit2.http.GET

interface CurrencyConverterRepository {

    @GET(CURRENY_EXCHANGE_RATES_API)
    suspend fun fetchCurencyExchangeRatesList():CurrencyConversionRatesList

}