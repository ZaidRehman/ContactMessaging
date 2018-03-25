package com.coderdeer.contactmessaging.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import com.coderdeer.contactmessaging.Adapters.ListAdapter
import com.coderdeer.contactmessaging.R
import kotlinx.android.synthetic.main.messaginglist_fragment_layout.*


/**
 * Created by qureshi on 25/03/18.
 */

class MessagingListFragment : Fragment() {
    var values = arrayOf("Hi. Your OTP is:\n" +
            "123456", "Hi. Your OTP is:\n" +
            "123456", "Hi. Your OTP is:\n" +
            "######")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.messaginglist_fragment_layout,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val list = ArrayList<String>()
        for (i in 0 until values.size) {
            list += values[i]
        }
        val adapter = ListAdapter(activity,
                android.R.layout.simple_list_item_1, list)


        message_listview.adapter = adapter


        message_listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as String

//            view.animate().setDuration(2000).alpha(0f)
//                    .withEndAction {
//                        //list.remove(item)
//
//                        contactAdapter.notifyDataSetChanged()
//                        view.alpha = 1f
//                    }
        }
    }

}