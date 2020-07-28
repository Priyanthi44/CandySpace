package com.appzupp.thechallenge.retrofit

import com.appzupp.thechallenge.model.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface LoadUsersRetrofit {
    @GET("/2.2/users/{USER_ID}?order=desc&sort=reputation&site=stackoverflow")
     suspend fun getUser(@Path(value = "USER_ID", encoded = false) key: Int) : Observable<UserNetworkEntity>
}