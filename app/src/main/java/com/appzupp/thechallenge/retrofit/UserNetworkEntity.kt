package com.appzupp.thechallenge.retrofit
import com.appzupp.thechallenge.model.Badges
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.sql.Date

data class UserNetworkEntity(
    @SerializedName("user_id")
    @Expose
    var id:Int,
    @SerializedName("display_name")
    @Expose
    var username:String,
    @SerializedName("reputation")
    @Expose
    var reputation:Int,
    @SerializedName("badge_counts")
    @Expose
    var badges:Badges,
    @SerializedName(" profile_image")
    @Expose
    var picture: String,
    @SerializedName("location")
    @Expose
    var Location:String,
    @SerializedName("user_id")
    @Expose
    var Age:Int,
    @SerializedName("user_id")
    @Expose
    var cdate: Date
)

