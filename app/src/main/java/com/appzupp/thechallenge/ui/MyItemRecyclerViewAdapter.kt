package com.appzupp.thechallenge.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.appzupp.thechallenge.R
import com.appzupp.thechallenge.model.UserListItem



/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: List<UserListItem>,
    private val itemclick: OnItemClickListener
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.reputation.toString()
        holder.contentView.text = item.username
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),View.OnClickListener {
        val idView: TextView = view.findViewById(R.id.reputation)
        val contentView: TextView = view.findViewById(R.id.user_name)

        override fun onClick(v: View?) {
            val position=adapterPosition
            if(position!=RecyclerView.NO_POSITION)
            itemclick.onItemClick(position)
        }

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
        init {
            view.setOnClickListener(this)

        }
    }
interface OnItemClickListener{
    fun onItemClick(position:Int)
}

}