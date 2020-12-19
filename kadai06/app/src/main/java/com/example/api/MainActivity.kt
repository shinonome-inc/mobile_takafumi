package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.e.api.ItemEntity
import com.e.api.ItemService
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
            .baseUrl("https://qiita.com/api/v2/docs")
            .addConverterFactory(GsonConverterFactory.create())
            //上はGsonのファクトリーメソッドに必須
            .build()

        val itemService = retrofit.create(ItemService::class.java)

        fun getItemList(callback: (List<ItemEntity>) -> Unit) {
            itemService.items(page = 1, perPage = 10).enqueue(object : Callback<List<ItemEntity>> {

                override fun onResponse(
                    call: Call<List<ItemEntity>>?,
                    response: Response<List<ItemEntity>>?) {
                    response?.let {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                callback(it)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<List<ItemEntity>>?, t: Throwable?) {}
                //上は処理が失敗したときの処理
            })
        }
    }
}