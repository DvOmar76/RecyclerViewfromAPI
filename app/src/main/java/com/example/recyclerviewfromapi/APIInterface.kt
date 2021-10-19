package com.example.recyclerviewfromapi

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/people/")
    fun getData():Call<Data>
}