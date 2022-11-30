package com.example.kotlinretrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdpater: MyAdpater
    lateinit var linearLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.recyclerView_users)

        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData =retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>,
            ) {
                val responceBody =response.body()!!


            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity","onFailuer : "+t.message)
            }
        })
    }
}