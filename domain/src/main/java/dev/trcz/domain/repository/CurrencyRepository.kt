package dev.trcz.domain.repository

import dev.trcz.domain.model.CurrencyRates

/**
 * Interface that represents a Repository for getting {@link CurrencyRates} related data.
 */
interface CurrencyRepository {

    /**
     * Get the latest currency rates.
     *
     * @param baseCurrency Optional - The base currency symbol to retrieve data.
     * @param symbols Optional - The specific symbols to retrieve.
     */
    suspend fun getLatestCurrencyRates(
        baseCurrency: String = "",
        vararg symbols: String = arrayOf()
    ): CurrencyRates
}