package com.example.apiApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import android.view.animation.AnimationUtils
import com.google.gson.Gson
import okhttp3.*

class MainActivity : AppCompatActivity() {

    //apiを呼び出す
    private val baseURL = "https://qiita.com/api/v2/items?page=1&per_page=20"
    //GetでRequestオブジェクトをBuilderクラスでURLなどを設定しながら生成
    private val request = Request.Builder().url(baseURL).build()
    //PostでOkHttpClientクラスのオブジェクト生成
    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                val body = response.body().toString()
                val gson = GsonBuilder().create()
                val gsondata = Gson().fromJson<gsonData>(str, )
            }
        })

    }
}