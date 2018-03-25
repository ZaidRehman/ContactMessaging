package com.coderdeer.contactmessaging.Fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.coderdeer.contactmessaging.R
import kotlinx.android.synthetic.main.contactlist_fragment_layout.*
import com.coderdeer.contactmessaging.Adapters.ContactAdapter
import com.coderdeer.contactmessaging.Profile
import com.coderdeer.contactmessaging.modal.Contact


/**
 * Created by qureshi on 25/03/18.
 */
//var values = arrayOf("Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Android", "iPhone", "WindowsMobile")

class ContactListFragment : Fragment() {

    var myListItems = ArrayList<Contact>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.contactlist_fragment_layout,container,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        val list = ArrayList<String>()
//        for (i in 0 until values.size) {
//            list += values[i]
//        }
//        val adapter = ContactListAdapter(activity,
//                android.R.layout.simple_list_item_1, list)


        //contact_listview.adapter = adapter

        myListItems.add(Contact("Zaid0","Qureshi",918452012514))
        myListItems.add(Contact("Zaid1","Qureshi",919967230912))

        val contactAdapter = ContactAdapter(activity,0,myListItems)
        contact_listview.adapter = contactAdapter

        contact_listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as Contact
            val intent = Intent(activity,Profile::class.java)
            intent.putExtra("Fname",item.Fname)
            intent.putExtra("Lname",item.Lname)
            intent.putExtra("number",item.number.toString())

            startActivity(intent)
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