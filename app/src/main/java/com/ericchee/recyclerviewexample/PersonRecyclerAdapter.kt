package com.ericchee.recyclerviewexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_person.view.*

/**
 * This class will generate the recycled views and load data when they come into screen using view holder pattern
 */
class PersonRecyclerAdapter(var listOfNames: List<String>): RecyclerView.Adapter<PersonRecyclerAdapter.PersonViewHolder>() {

    var onPersonClickedListener: ((position: Int, name: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewHolderType: Int): PersonViewHolder {
        // Creates ViewHolder to hold reference of the views
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        // Size of items to load
        return listOfNames.size
    }

    override fun onBindViewHolder(viewHolder: PersonViewHolder, position: Int) {
        // Sets data on view
        viewHolder.bindView(listOfNames[position], position)
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(personName: String, position: Int) {
            itemView.tvName.text = personName

            itemView.setOnClickListener {
                onPersonClickedListener?.invoke(position, personName)
            }
        }
    }

    fun updateList(newListOfNames: List<String>) {
        this.listOfNames = newListOfNames

        // Call this when you change the data of Recycler View to refresh the items
        notifyDataSetChanged()
    }
}


