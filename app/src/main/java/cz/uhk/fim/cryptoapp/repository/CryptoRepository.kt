package cz.uhk.fim.cryptoapp.repository

import cz.uhk.fim.cryptoapp.model.Crypto


// TODO: Nahradit za reálná data z API
object CryptoRepository {
    private val cryptoList = listOf(
        Crypto("bitcoin", "BTC", "Bitcoin", "40000.00", "2.5"),
        Crypto("ethereum", "ETH", "Ethereum", "3000.00", "-1.2"),
        Crypto("cardano", "ADA", "Cardano", "1.00", "0.5"),
        Crypto("solana", "SOL", "Solana", "100.00", "3.0")
    )

    //todo getCryptoList
    fun getCryptoList(): List<Crypto>
    {
        return cryptoList
    }

    //todo getCryptoById
    fun getCryptoById(cryptoId: String): Crypto?
    {
        return cryptoList.find{ it.id == cryptoId}
    }

    //todo add, remove, isIn favorites

}