package com.example.apiApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import android.view.animation.AnimationUtils
import androidx.fragment.app.FragmentActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //apiを呼び出す
        val baseURL = "https://qiita.com/api/v2/items?page=1&per_page=20"
        //GetでRequestオブジェクトをBuilderクラスでURLなどを設定しながら生成
        val request = Request.Builder().url(baseURL).build()
        //PostでOkHttpClientクラスのオブジェクト生成
        val client = OkHttpClient()

        client.newCall(request).enqueue(object: okhttp3.Callback {
            //fragment処理が成功したとき
            override fun onResponse(call: Call, response: Response) {
                val body = response.body().toString()
                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, Array<HomeFeed>::class.java)

                runOnUiThread {
                    val adapter = Adapter(homeFeed)
                    val layoutManager = LinearLayoutManager(this@MainActivity)

                    recyclerView.layoutManager = layoutManager
                    recyclerView.adapter = adapter
                    //fragmentの初期値
                    recyclerView.setHasFixedSize(true)

                    //記事を押したときの処理
                    adapter.setOnItemClickListener(object: Adapter.OnItemClickListener {
                        override fun onItemClickListener(view: View, position: Int, url: String) {
                            val fragment = fragment.newInstance(baseURL)
                            val fragmentTransition = supportFragmentManager.beginTransaction()

                            //スライド移動
                            fragmentTransition.setCustomAnimations(
                                R.anim.close_enter,
                                R.anim.close_exit,
                                R.anim.open_enter,
                                R.anim.open_exit
                            )

                            fragmentTransition.add(R.id.container, fragment, "fragment")
                            fragmentTransition.addToBackStack(null)
                            fragmentTransition.commit()
                        }
                    })
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("failed to execute request")
            }
        })
    }
}