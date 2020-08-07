package com.appzupp.thechallenge.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject

class MainFragmentFactory
    @Inject
    constructor(private val someString:String): FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            SearchFragment::class.java.name->{
                SearchFragment()
            }
            ItemFragment::class.java.name->{
                ItemFragment()
            }else ->  return super.instantiate(classLoader, className)
        }

    }
}