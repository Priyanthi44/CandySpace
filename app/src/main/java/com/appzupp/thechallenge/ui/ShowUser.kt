package com.appzupp.thechallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import com.appzupp.thechallenge.R
import com.appzupp.thechallenge.model.UserListItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_show_user.*

class ShowUser() : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_user)
        intent?.let{
            val user= intent.extras?.getParcelable<UserListItem>(MainActivity.USER)
            if (user != null) {
                Picasso.get().load(user.picture).into(imageView)
                textView.text=user.username
            }
        }

    }

private fun initialise(imageURL:String){
    Picasso.get().load(imageURL).into(imageView)
}
}