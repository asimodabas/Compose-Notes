package com.asimodabas.compose_notes.service

import com.asimodabas.compose_notes.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    //asimodabas/Crypto-Tracking/master/crypto.json
    //https://raw.githubusercontent.com/
    @GET("asimodabas/Crypto-Tracking/master/crypto.json")
    fun getData():Call<List<CryptoModel>>

}