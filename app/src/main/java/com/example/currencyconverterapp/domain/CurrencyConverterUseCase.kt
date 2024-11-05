package com.example.currencyconverterapp.domain

import com.example.currencyconverterapp.data.remote.models.CurrencyConverterRepositoryImpl
import javax.inject.Inject

class CurrencyConverterUseCase @Inject constructor(
    private val currencyConverterRepositoryImpl: CurrencyConverterRepositoryImpl
) {
    suspend operator fun invoke() = currencyConverterRepositoryImpl.fetchCurencyExchangeRatesList()
}