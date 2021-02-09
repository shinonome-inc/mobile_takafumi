package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://qiita.com/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        //上はGsonのファクトリーメソッドに必須
        .build()

    private val itemService = retrofit.create(ItemService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemService.items(1, 20).enqueue(object : Callback<List<ItemEntity>> {
            override fun onFailure(call: Call<List<ItemEntity>>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<ItemEntity>>,
                response: Response<List<ItemEntity>>
            ) {
                text1.text = response.body().toString()
            }

        })
    }
}