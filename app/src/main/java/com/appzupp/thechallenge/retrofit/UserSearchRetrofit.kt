package com.appzupp.thechallenge.retrofit

import io.reactivex.Flowable
import io.reactivex.Maybe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserSearchRetrofit {
   // @GET("2.2/users?order=desc&max=20&sort=reputation&inname={Query}&site=stackoverflow")
    @GET("/2.2/users")
     fun getData(
       @Query("order") desc: String,
       @Query("max") twty: Int,
       @Query("sort") reputation: String,
       @Query("inname") key: String,
       @Query("site") stackoverflow: String) : Flowable<List<UserListItemNetworkEntity>>
}