package com.appzupp.thechallenge.di

import com.appzupp.thechallenge.retrofit.LoadUsersRetrofit
import com.appzupp.thechallenge.retrofit.UserSearchRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder{
        return   Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/docs")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }
    @Singleton
    @Provides
    fun provideUserSerchService(retrofit: Retrofit.Builder): UserSearchRetrofit{
        return retrofit.build()
            .create(UserSearchRetrofit::class.java)
    }
    @Singleton
    @Provides
    fun provideUserListService(retrofit: Retrofit.Builder): LoadUsersRetrofit{
        return retrofit.build()
            .create(LoadUsersRetrofit::class.java)
    }
}