package cz.uhk.fim.cryptoapp.const

object Routes {
    const val CryptoList = "cryptoList"
    const val CryptoDetail = "cryptoDetail/{cryptoId}"
    const val FavouriteCrypto = "favouriteCrypto"

    fun cryptoDetail(cryptoId: String): String
    {
        return "cryptoDetail/$cryptoId"
    }
}