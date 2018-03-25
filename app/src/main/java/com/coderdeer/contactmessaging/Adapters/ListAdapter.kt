package com.coderdeer.contactmessaging.Adapters


import android.content.Context
import android.widget.ArrayAdapter

class ListAdapter(context: Context, textViewResourceId: Int,
                                 objects: List<String>) : ArrayAdapter<String>(context, textViewResourceId, objects) {

    internal var mIdMap = HashMap<String, Int>()

    init {

        for (i in objects.indices) {
            mIdMap[objects[i]] = i
        }
    }



    override fun getItemId(position: Int): Long {
        val item = getItem(position)
        return mIdMap[item]?.toLong() ?: -1
    }

    override fun hasStableIds(): Boolean {
        return true
    }

}