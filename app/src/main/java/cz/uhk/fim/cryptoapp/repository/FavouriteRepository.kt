package cz.uhk.fim.cryptoapp.repository

import cz.uhk.fim.cryptoapp.model.Crypto
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

// TODO simulace komunikce s lokální DB
class FavouriteRepository {
    private val _favouriteCrypto = MutableStateFlow<List<Crypto>>(emptyList())
    val favouriteCrypto: StateFlow<List<Crypto>>
        get() = _favouriteCrypto.asStateFlow()

    //přidání zabare nějaký čas - suspend
    suspend fun addFavouriteCrypto(crypto: Crypto)
    {
        delay(1000)
        _favouriteCrypto.value += crypto
    }

    suspend fun removeFavouriteCrypto(crypto: Crypto)
    {
        delay(1000)
        _favouriteCrypto.value -= crypto
    }
}