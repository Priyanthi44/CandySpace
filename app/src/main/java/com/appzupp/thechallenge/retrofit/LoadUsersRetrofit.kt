package com.appzupp.thechallenge.retrofit

import io.reactivex.Observable
import retrofit2.http.GET

interface LoadUsersRetrofit {
    @GET("/2.2/users/USER_ID?order=desc&sort=reputation&site=stackoverflow")
    fun getUser() : Observable<List<UserNetworkEntity>>
}