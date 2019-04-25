package com.ericchee.recyclerviewexample.animated

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ericchee.recyclerviewexample.R
import kotlinx.android.synthetic.main.item_person.view.*

/**
 * This is the same RecyclerView but using DiffUtil instead of notifyDataSetChanged() to animate changes
 */
class PersonRecyclerAdapterAnimated(var listOfNames: List<String>): RecyclerView.Adapter<PersonRecyclerAdapterAnimated.PersonViewHolder>() {

    var onPersonClickedListener: ((position: Int, name: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewHolderType: Int): PersonViewHolder = PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false))

    override fun getItemCount(): Int = listOfNames.size

    override fun onBindViewHolder(viewHolder: PersonViewHolder, position: Int) {
        viewHolder.bindView(listOfNames[position], position)
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(personName: String, position: Int) {
            itemView.tvName.text = personName
            itemView.setOnClickListener { onPersonClickedListener?.invoke(position, personName) }
        }
    }

    /**
     *  THIS IS THE ONLY DIFFERENCE BETWEEN the regular PersonRecyclerAdapter (This class couldve subclassed but wrote full class for illustration
     */
    fun updateList(newListOfNames: List<String>) {

        val diffCallback = NameDiffCallback(this.listOfNames, newListOfNames)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)

        this.listOfNames = newListOfNames
    }
}


