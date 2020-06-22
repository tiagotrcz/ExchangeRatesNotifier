package dev.trcz.domain.interactor

import dev.trcz.domain.model.CurrencyRates
import dev.trcz.domain.repository.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

/**
 * This class represents a use case for retrieving {@link CurrencyRates}.
 */
class GetCurrencyRatesUseCase @Inject constructor(private val repository: CurrencyRepository) {
    suspend operator fun invoke(
        baseCurrency: String = "",
        vararg symbols: String = arrayOf()
    ): Either<Exception, CurrencyRates> {
        return withContext(Dispatchers.IO) {
            try {
                val rates = repository.getLatestCurrencyRates(baseCurrency, *symbols)
                Success(rates)
            } catch (e: Exception) {
                Failure(e)
            }
        }
    }
}