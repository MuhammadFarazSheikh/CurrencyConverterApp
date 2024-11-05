package com.example.currencyconverterapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverterapp.data.remote.models.CurrencyConversionRatesList
import com.example.currencyconverterapp.domain.CurrencyConverterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val currencyConverterUseCase: CurrencyConverterUseCase
): ViewModel() {

    val currencyConversionRatesListMutableStateFlow = MutableStateFlow(CurrencyConversionRatesList())

    init {
        viewModelScope.launch {
            currencyConverterUseCase()
        }
    }
}