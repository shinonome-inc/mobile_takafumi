package com.e.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


data class ItemEntity (
    val id: String, //記事ID
    val title: String, //タイトル
    val body: String //記事の中身
)

interface ItemService {

    // retrofit 標準のコールバックで結果を受け取る
    @GET("items")
    fun items(
        @Query("page") page: Int,
        @Query("par_page") perPage: Int
    ): Call<List<ItemEntity>>
}