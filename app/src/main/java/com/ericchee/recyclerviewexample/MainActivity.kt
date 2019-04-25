package com.ericchee.recyclerviewexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ericchee.recyclerviewexample.animated.PersonRecyclerAdapterAnimated
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var useSecondList = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfPeople = listOf("Eric", "Joy", "Ted", "Baymax", "Pikachu", "Spiderman", "SpongeBob Squarepants", "Captain Holt", "Tyrion Lannister", "Eminem")

        val adapter = PersonRecyclerAdapterAnimated(listOfPeople)
        myRecyclerView.adapter = adapter
        myRecyclerView.setHasFixedSize(true)

        adapter.onPersonClickedListener = { position, name ->
            Toast.makeText(this, "$name clicked!", Toast.LENGTH_SHORT).show()
        }

        val secondListOfPeople = listOf("Baymax", "Captain Marve", "Morgan Freeman", "Eminem", "Pikachu", "James Bond", "Linkin Park", "Eric", "SpongeBob Squarepants", "Captain Holt", "Spiderman", "Tyrion Lannister", "50 Cent")
        btnChangeList.setOnClickListener {
            val newList = if (useSecondList) secondListOfPeople else listOfPeople
            adapter.updateList(newList)

            useSecondList = !useSecondList
        }

        /*
        Creating a RecyclerView:

            - Add support library as dependency for RecyclerView in build.gradle (app module)
                see: https://developer.android.com/topic/libraries/support-library/packages#v7-recyclerview

            - Add RecyclerView view in activity xml or where ever you want it to go
                don't forget to add LayoutManager in xml or code or it wont show!

            - created a shared layout xml file for items in RecyclerView

            - Create RecyclerAdapter class

                - Create custom ViewHolder inner class inside RecyclerAdapter
                    save views that will show variable data

                - Create RecyclerView constructor that takes the collection data to present

                - In RecyclerAdapter.getItemCount()- set size of list
                - in RecyclerAdapter.onCreateViewHolder() - created instance of your custom ViewHolder class
                - In RecyclerAdapter.onBindViewHolder() - set data in the view

            - Create adapter in activity/fragment. Pass in data set
            - Set adapter to RecyclerView

            - Optional:
                - Call adapter.notifyDataSetChanged() when changes have been made to data set
                - For cool animations checkout DiffUtil
                    https://medium.com/@gabornovak/use-diffutil-for-out-of-the-box-animations-d932a28d6229
         */

        /*
          Change type of LayoutManager to set how items are laid out

            myRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                or
            myRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                or
            myRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        */
    }
}
