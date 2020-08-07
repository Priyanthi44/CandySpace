package com.appzupp.thechallenge.di

import com.appzupp.thechallenge.retrofit.UserSearchRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
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
            .baseUrl("https://api.stackexchange.com/docs/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    }

    @Singleton
    @Provides
    fun provideUserSearchService(retrofit: Retrofit.Builder): UserSearchRetrofit{
        return retrofit.build()
            .create(UserSearchRetrofit::class.java)
        
    }

}