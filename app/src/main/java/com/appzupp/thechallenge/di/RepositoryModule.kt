package com.appzupp.thechallenge.di

import com.appzupp.thechallenge.repository.MainRepository
import com.appzupp.thechallenge.retrofit.UserListItemNetworkMapper
import com.appzupp.thechallenge.retrofit.UserSearchRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {
@Singleton
@Provides
fun provideMainRepository(
    retrofit:UserSearchRetrofit,
    networkMapper: UserListItemNetworkMapper
):MainRepository{
    return MainRepository(retrofit,networkMapper)
}
}