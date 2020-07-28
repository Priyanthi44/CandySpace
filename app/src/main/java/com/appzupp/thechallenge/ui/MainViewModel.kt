package com.appzupp.thechallenge.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.repository.MainRepository
import com.appzupp.thechallenge.util.NetworkState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.security.PrivateKey

class MainViewModel
@ViewModelInject
constructor(@Assisted private val savedStateHandle: SavedStateHandle,
private val mainRepository: MainRepository): ViewModel() {
private val networkState:MutableLiveData<NetworkState<List<UserListItem>>> = MutableLiveData()
    val state_net: LiveData<NetworkState<List<UserListItem>>>
        get() =networkState

    @ExperimentalCoroutinesApi
    fun setStateEvent(event: StateEvent, q: String) {
        viewModelScope.launch {
            when(event){
                is StateEvent.GetSearchList->{
                    mainRepository.getUserList(q)
                        .onEach { state_net ->
                            networkState.value =state_net
                        }.launchIn(viewModelScope)
                }
            }
        }
    }
}

sealed class StateEvent{
    object GetSearchList: StateEvent()
    object GetUser:StateEvent()
    object None:StateEvent()
}