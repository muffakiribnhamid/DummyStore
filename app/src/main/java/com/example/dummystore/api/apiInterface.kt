package com.example.dummystore.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface apiInterface {



    @GET("products/{id}")
    fun getData(@Path("id")id : String) : Call<Items>



}