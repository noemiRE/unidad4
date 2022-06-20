package com.example.unidad4.network

import com.example.unidad4.models.Character
import retrofit2.http.GET

interface StartWarsService {

    //suspend ktlin sabe que solo se ejecutara dentro de corutina
    @GET("all.json")
    suspend fun getCharacters():List<Character>

}