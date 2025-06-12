
package com.example.hercryptoapp.data.model
data class CryptoModel(
    val id: String,
    val symbol: String,
    val name: String,
    val current_price: Double,
    val price_change_percentage_24h: Double,
    val market_cap: Double,
    val image: String,
    val priceHistory: List<Double>
)
