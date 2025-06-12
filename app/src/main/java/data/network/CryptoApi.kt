package com.example.hercryptoapp.data.network

import com.example.hercryptoapp.data.model.CryptoModel
import retrofit2.http.GET

interface CryptoApi {
    @GET("api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=true")
    suspend fun getCryptoList(): List<CryptoModel>
}