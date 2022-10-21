package com.example.myapplication2.retrofit

import com.example.myapplication2.model.ServicesSetterGetter
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("fact")
    fun getServices() : Call<ServicesSetterGetter>

}