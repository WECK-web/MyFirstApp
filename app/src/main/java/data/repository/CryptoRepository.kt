package com.example.hercryptoapp.data.repository

import com.example.hercryptoapp.data.model.CryptoModel
import com.example.hercryptoapp.data.network.CryptoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoRepository {
    private val api: CryptoApi = Retrofit.Builder()
        .baseUrl("https://api.coingecko.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CryptoApi::class.java)

    suspend fun getCryptoList(): List<CryptoModel> {
        return try {
            api.getCryptoList()
        } catch (e: Exception) {
            emptyList()
        }
    }
}