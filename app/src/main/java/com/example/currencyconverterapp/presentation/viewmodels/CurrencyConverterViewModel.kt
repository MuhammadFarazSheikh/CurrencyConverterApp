package com.example.currencyconverterapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverterapp.data.remote.models.CurrencyConversionUiStateModel
import com.example.currencyconverterapp.data.remote.models.Resource
import com.example.currencyconverterapp.domain.CurrencyConverterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyConverterViewModel @Inject constructor(
    private val currencyConverterUseCase: CurrencyConverterUseCase
): ViewModel() {

    val currencyConversionUiStateModelMutableStateFlow = MutableStateFlow(CurrencyConversionUiStateModel())

    init {
        viewModelScope.launch {
            val currencyConversionRates = currencyConverterUseCase()
            when(currencyConversionRates)
            {
                is Resource.Success -> currencyConversionUiStateModelMutableStateFlow.emit(currencyConversionRates.value.copy(isShowLoader = false, isFailed = false))
                is Resource.Failure -> currencyConversionUiStateModelMutableStateFlow.emit(CurrencyConversionUiStateModel(isFailed = true))
            }
        }
    }
}