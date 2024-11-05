package com.example.currencyconverterapp.data.remote.models

import com.example.currencyconverterapp.data.remote.repositories.BaseRepository
import com.example.currencyconverterapp.data.remote.repositories.CurrencyConverterRepository
import javax.inject.Inject

class CurrencyConverterRepositoryImpl @Inject constructor(
    private val currencyConverterRepository: CurrencyConverterRepository
): BaseRepository() {
    suspend fun fetchCurencyExchangeRatesList()= safeApiCall {
        currencyConverterRepository.fetchCurencyExchangeRatesList()
    }
}