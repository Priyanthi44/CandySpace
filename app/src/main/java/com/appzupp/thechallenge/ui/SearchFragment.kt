package com.appzupp.thechallenge.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.appzupp.thechallenge.R
import com.appzupp.thechallenge.model.UserListItem
import com.appzupp.thechallenge.util.NetworkState
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.concurrent.TimeUnit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_item_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SearchFragment
    constructor():BaseActivity()
{
    private val viewModel:MainViewModel by viewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manageClicks()
    }
    private fun sendQuery():String{
        return search_query.text.toString()
    }
    private fun manageClicks(){
        // addSub(RxView.clicks(btnsearch).throttlefirst{})
        val emitter= PublishSubject.create<View>()
        btnsearch.setOnClickListener { v ->
            if (v != null) {

                emitter.onNext(v)
            }
        }
        addSub(emitter
            .map{}
            .throttleFirst(3000, TimeUnit.MILLISECONDS)
            .subscribe{subscribeNet()})
    }
    private fun subscribeNet(){
        val q=sendQuery()
        if(q.length>1) {
            viewModel.setQuery(q)
                viewModel.setStateEvent(StateEvent.GetSearchList)
           }
        else{}
        // Toast.makeText(viewLifecycleOwner, "Please Enter a valid input", Toast.LENGTH_LONG).show()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }






}