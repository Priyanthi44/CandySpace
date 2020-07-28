package com.appzupp.thechallenge.retrofit

import io.reactivex.Maybe
import retrofit2.http.GET
import retrofit2.http.Path

interface UserSearchRetrofit {
    @GET("/2.2/users?order=desc&max=20&sort=reputation&inname={SEARCH_VALUE}&site=stackoverflow")
     suspend fun getData(@Path(value = "SEARCH_VALUE", encoded = false) key: String) : List<UserListItemNetworkEntity>
}