# RecyclerViewExample
Simple example of RecyclerView in Kotlin

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
