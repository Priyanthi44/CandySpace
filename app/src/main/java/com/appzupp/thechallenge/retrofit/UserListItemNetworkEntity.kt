package com.appzupp.thechallenge.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserListItemNetworkEntity (@SerializedName("user_id")
                                      @Expose
                                      var id:Int,
                                      @SerializedName("display_name")
                                      @Expose
                                      var username:String,
                                      @SerializedName("reputation")
                                      @Expose
                                      var reputation:Int)