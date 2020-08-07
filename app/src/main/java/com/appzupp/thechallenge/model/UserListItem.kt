package com.appzupp.thechallenge.model

import android.os.Parcel
import android.os.Parcelable

data class Badges(
    var gold: Int,
    var silver: Int,
    var Bronze: Int
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(gold)
        parcel.writeInt(silver)
        parcel.writeInt(Bronze)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Badges> {
        override fun createFromParcel(parcel: Parcel): Badges {
            return Badges(parcel)
        }

        override fun newArray(size: Int): Array<Badges?> {
            return arrayOfNulls(size)
        }
    }
}

data class UserListItem(
    var id:Int,
    var username: String?,
    var reputation:Int,
    var badges:Badges?,
    var picture: String?,
    var Location:String?,
    var Age:Int,
    var cdate: Int

):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readParcelable(Badges::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(username)
        parcel.writeInt(reputation)
        parcel.writeParcelable(badges, flags)
        parcel.writeString(picture)
        parcel.writeString(Location)
        parcel.writeInt(Age)
        parcel.writeInt(cdate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserListItem> {
        override fun createFromParcel(parcel: Parcel): UserListItem {
            return UserListItem(parcel)
        }

        override fun newArray(size: Int): Array<UserListItem?> {
            return arrayOfNulls(size)
        }
    }

}


