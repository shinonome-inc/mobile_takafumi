package com.example.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

data class ItemEntity (
    val id: String,
    val title: String,
    val user: User
)

data class User(
    val name: String
)

interface ItemService {
    @GET("items")
    fun items(@Query("page") page: Int, @Query("per_page") perPage: Int): Call<List<ItemEntity>>
}