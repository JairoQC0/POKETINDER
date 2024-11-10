package com.jairoqc.poketinder

import com.jairoqc.poketinder.api.PokemonApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL = "https://pokeapi.co"


    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("NAME-HEADER", "VALUE-HEADER")
                    .build()
                chain.proceed(newRequest)
            }
            .build()
    }


    val api: PokemonApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client) // Usa el cliente que contiene las cabeceras
            .build()
            .create(PokemonApi::class.java)
    }
}
