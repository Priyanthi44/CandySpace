package com.appzupp.thechallenge.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.appzupp.thechallenge.R
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.util.NetworkState
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_item_list.*
import kotlinx.android.synthetic.main.fragment_search.*
import java.text.FieldPosition
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity: AppCompatActivity() {
    @Inject
    lateinit var fragmentFactory: MainFragmentFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       supportFragmentManager.fragmentFactory=fragmentFactory
       supportFragmentManager.beginTransaction()
           .add(R.id.mainlayout,SearchFragment::class.java,null)
           .add(R.id.mainlayout,ItemFragment::class.java,null)
           .commit()
        MainActivity.Companion.setContext(this)

       // manageLayout()



    }

    companion object {

            const val USER= "user"

        private lateinit var context: Context

        fun setContext(con: Context) {
            context=con
        }
        fun getContext():Context {
            return context
        }
    }


 fun manageLayout(){
    val search=SearchFragment()
    val list=ItemFragment()
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.add(R.id.mainlayout,search,"searchfragment")
        .add(R.id.mainlayout,list,"listfragment").commit()



}












}








