package com.appzupp.thechallenge.util

import java.lang.Exception

sealed class NetworkState<out R> {
    data class Success <out T>(val data:T):NetworkState<T>()
    data class Error (val exception: Exception):NetworkState<Nothing>()
    object Loading :NetworkState<Nothing>()

}