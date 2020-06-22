package dev.trcz.domain.model

import javax.inject.Inject

data class CurrencyRates @Inject constructor(
    val rates: Map<String, Double>,
    val base: String
)