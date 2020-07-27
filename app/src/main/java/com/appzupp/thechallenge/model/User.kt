package com.appzupp.thechallenge.model

import java.sql.Date

data class User (var id:Int,
                 var username:String,
                 var reputation:Int,
                 var badges:Badges,
                 var picture: String,
                 var Location:String,
                 var Age:Int,
                 var cdate:Date

)
data class Badges(
    var gold: Int,
    var silver: Int,
    var Bronze: Int
)
