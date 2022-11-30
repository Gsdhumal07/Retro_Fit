package com.example.kotlinretrofitdemo

import com.google.gson.annotations.SerializedName

data class MyDataItem(
   // @SerializedName("body")     in case our variables is not match with the specified variables then in such case it work
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)