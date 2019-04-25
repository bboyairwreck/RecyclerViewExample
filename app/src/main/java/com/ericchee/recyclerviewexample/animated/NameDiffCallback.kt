package com.ericchee.recyclerviewexample.animated

import android.support.v7.util.DiffUtil

open class NameDiffCallback(
        val oldNames: List<String>,
        val newNames: List<String>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldNames.size
    }

    override fun getNewListSize(): Int {
        return newNames.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // Typically compare some kinda of unique id

        return oldNames[oldItemPosition] == newNames[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // This is called if areItemsTheSame() == true; Check if content instead the same item has changed
        return oldNames[oldItemPosition] == newNames[newItemPosition]
    }
}