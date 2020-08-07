package com.appzupp.thechallenge.repository

import android.content.ContentValues.TAG
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.retrofit.UserListItemNetworkEntity
import com.appzupp.thechallenge.retrofit.UserListItemNetworkMapper
import com.appzupp.thechallenge.retrofit.UserSearchRetrofit
import com.appzupp.thechallenge.ui.BaseActivity
import com.appzupp.thechallenge.ui.MainActivity
import com.appzupp.thechallenge.util.NetworkState
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository
constructor(

private val userlist:UserSearchRetrofit,
private val userlistMapper:UserListItemNetworkMapper) {



    /*TODO()
    *call maybe rxjava for observables
    * network state to loading to show progrss bar
    * need to cache data only for the list for the back button
    * add query to a set with hashmap so that same requests are not frequently downloaded
    * SQL lite database is not used as these queries do not need to be persisted
    * Just aiming for providing a good user interaction


    }

        suspend fun getUserList(query: String):Flow<NetworkState<List<UserListItem>>> =flow{
            emit(NetworkState.Loading)
            try{
                val netuserlist= userlist.getData("desc",20,"reputation",query,"stackoverflow")

                val userList=userlistMapper.mapFromEntityList(netuserlist)
                emit(NetworkState.Success(userList))
            }catch(e:Exception){
                emit(NetworkState.Error(e))
            }

       }
    */
    private val disposable:CompositeDisposable = CompositeDisposable()





}


