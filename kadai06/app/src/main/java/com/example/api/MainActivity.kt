package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://qiita.com/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            //上はGsonのファクトリーメソッドに必須
            .build()

        val itemService = retrofit.create(ItemService::class.java)

        itemService.items(1, 20)?.enqueue(object: Callback<List<ItemEntity?>?> {
            override fun onFailure(call: Call<List<ItemEntity?>?>, t: Throwable){
                Log.d("Error", t.message.toString())
            }

            override fun onResponse(call: Call<List<ItemEntity?>?>, response: Response<List<ItemEntity?>?>) {
                Log.d("Successful", response.body().toString())
            }
    
        })
    }
}
