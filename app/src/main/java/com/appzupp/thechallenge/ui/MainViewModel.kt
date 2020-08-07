package com.appzupp.thechallenge.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.repository.MainRepository
import com.appzupp.thechallenge.retrofit.UserListItemNetworkEntity
import com.appzupp.thechallenge.retrofit.UserListItemNetworkMapper
import com.appzupp.thechallenge.retrofit.UserSearchRetrofit
import com.appzupp.thechallenge.util.NetworkState
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel

@ViewModelInject
constructor(@Assisted private val savedStateHandle: SavedStateHandle
            private val userlist: UserSearchRetrofit,
            private val userlistMapper: UserListItemNetworkMapper
): ViewModel() {


private val networkState:MediatorLiveData<NetworkState<List<UserListItem>>> = MediatorLiveData()

private lateinit var  query:String

    val state_net: LiveData<NetworkState<List<UserListItem>>>
        get() =networkState

fun setQuery(q:String){
    query=q
}

    @ExperimentalCoroutinesApi
    fun setStateEvent(
        event: StateEvent
    ) {
        viewModelScope.launch {
            when(event){
                is StateEvent.GetSearchList->{
                    getUserList(query)
                        .onEach { state_net ->
                            networkState.value =state_net
                        }.launchIn(viewModelScope)
                }
            }
        }
    }

    fun getUserList(query: String) {
        val source: LiveData<List<UserListItemNetworkEntity>> = LiveDataReactiveStreams.fromPublisher(
            userlist.getData("desc", 20, "reputation", query, "stackoverflow")
                .subscribeOn(Schedulers.io())
        )
networkState.addSource(source, 

    }
}

sealed class StateEvent{
    object GetSearchList: StateEvent()
    object None:StateEvent()
}