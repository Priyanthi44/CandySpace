package com.appzupp.thechallenge.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.appzupp.thechallenge.R
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.util.NetworkState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private val viewModel:MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        manageLayout()
    }
fun manageLayout(){
    val search=SearchFragment()
    val list=ItemFragment()
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.add(R.id.mainlayoyt,search,"searchfragment")
    fragmentTransaction.add(R.id.mainlayoyt,list,"listfragment")
    fragmentTransaction.commit()

}

    fun subscribe(){
        viewModel.state_net.observe(this, Observer { state_net->
        when(state_net){
            is NetworkState.Success<List<UserListItem>> ->{

            }
            is NetworkState.Error ->{

            }
            is NetworkState.Loading ->{

            }
        }})
    }

    private fun displayError(message: String?){
        if(message!=null)
        Toast.makeText(this, message, Toast.LENGTH_LONG)
    }
}