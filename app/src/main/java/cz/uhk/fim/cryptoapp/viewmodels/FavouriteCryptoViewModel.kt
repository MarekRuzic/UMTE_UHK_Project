package cz.uhk.fim.cryptoapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.uhk.fim.cryptoapp.model.Crypto
import cz.uhk.fim.cryptoapp.repository.FavouriteRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavouriteCryptoViewModel(private val cryptoRepository: FavouriteRepository): ViewModel() {
    val favouriteCryptoList: StateFlow<List<Crypto>> = cryptoRepository.favouriteCrypto

    fun addFavouriteCrypto(crypto: Crypto){
        viewModelScope.launch {
            cryptoRepository.addFavouriteCrypto(crypto)
        }
    }

    fun removeFavouriteCrypto(crypto: Crypto)
    {
        viewModelScope.launch {
            cryptoRepository.removeFavouriteCrypto(crypto)
        }
    }
}