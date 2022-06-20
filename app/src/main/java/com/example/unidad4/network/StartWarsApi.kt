package com.example.unidad4.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object StartWarsApi {
//implementa moshi
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
//implementa retrofit
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))//retrofit utiliza moshi
        .baseUrl("https://akabab.github.io/starwars-api/api/")
        .build()
//crear implementacion de nuestra interface
    val service:StartWarsService = retrofit.create(StartWarsService::class.java)
}