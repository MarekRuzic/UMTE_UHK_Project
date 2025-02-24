package cz.uhk.fim.cryptoapp.model

// id, symbol, name, priceUSD,  changePercent24Hr
data class Crypto(
    val id: String,
    val symbol: String,
    val name: String,
    val priceUSD: String,
    val changePercent24Hr: String)
