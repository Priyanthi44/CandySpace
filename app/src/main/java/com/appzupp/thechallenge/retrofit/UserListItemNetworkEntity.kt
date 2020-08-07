package com.appzupp.thechallenge.retrofit

import com.appzupp.thechallenge.model.Badges
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Date

data class UserListItemNetworkEntity (
    @SerializedName("user_id")
    @Expose
    var id:Int,
    @SerializedName("display_name")
    @Expose
    var username:String?,
    @SerializedName("reputation")
    @Expose
    var reputation:Int,
    @SerializedName("badge_counts")
    @Expose
    var badges:Badges?,
    @SerializedName(" profile_image")
    @Expose
    var picture: String?,
    @SerializedName("location")
    @Expose
    var Location:String?,
    @SerializedName("age")
    @Expose
    var Age:Int,
    @SerializedName("creation_date")
    @Expose
    var cdate: Int
)