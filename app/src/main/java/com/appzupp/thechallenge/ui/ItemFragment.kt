package com.appzupp.thechallenge.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.appzupp.thechallenge.R
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.util.NetworkState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_item_list.*


/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class ItemFragment
    constructor(): Fragment(),MyItemRecyclerViewAdapter.OnItemClickListener {
private val TAG:String="AppDebug"
    private var columnCount = 1

    private var dataset:List<UserListItem> = ArrayList<UserListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        /*
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter()
            }
        }*/
         val viewModel:MainViewModel by viewModels()
        viewModel.state_net.observe(viewLifecycleOwner, Observer { state_net->
            when(state_net){

                is NetworkState.Success<List<UserListItem>> ->{
                    displayProgress(false)
                    dataset=state_net.data
                    populateView(state_net.data)
                }
                is NetworkState.Error ->{
                    displayProgress(false)
                    displayError(state_net.exception.message)
                }
                is NetworkState.Loading ->{
                    displayProgress(true)
                }
            }})
        return view
    }
    private fun populateView(data:List<UserListItem>) {
        if (data.isNotEmpty()) {
            list.adapter=MyItemRecyclerViewAdapter(data,this)
            list.layoutManager= LinearLayoutManager(MainActivity.getContext())
            list.setHasFixedSize(true)

        } else {
            Toast.makeText(MainActivity.getContext(),"User not found!", Toast.LENGTH_LONG).show()
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // Log.d(TAG,"Heres: ${someString}")

    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
    override fun onItemClick(position: Int) {
        val intent = Intent(MainActivity.getContext(), ShowUser::class.java).apply {

            putExtra(MainActivity.USER, dataset.get(position) )
        }
        startActivity(intent)
    }
    private fun displayProgress(isdisplayed:Boolean){
        if(isdisplayed)

        progress_circular.visibility =View.VISIBLE
        else
        progress_circular.visibility =View.GONE
    }
    private fun displayError(message: String?){
        if(message!=null)
            Toast.makeText(MainActivity.getContext(), message, Toast.LENGTH_LONG).show()
    }

}