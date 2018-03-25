package com.coderdeer.contactmessaging.Adapters

import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ArrayAdapter
import com.coderdeer.contactmessaging.R
import com.coderdeer.contactmessaging.modal.Contact


/**
 * Created by qureshi on 25/03/18.
 */
class ContactAdapter(activity: Activity, textViewResourceId: Int, _lPerson: ArrayList<Contact>) : ArrayAdapter<Contact>(activity, textViewResourceId, _lPerson) {
    private var activity: Activity? = null
    private var lPerson: ArrayList<Contact>? = null

    init {
        try {
            this.activity = activity
            this.lPerson = _lPerson

            inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        } catch (e: Exception) {

        }

    }

    override fun getCount(): Int {
        return lPerson?.size ?: 0
    }

    fun getItem(position: Contact): Contact {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class ViewHolder {
        var display_name: TextView? = null
        var display_number: TextView? = null

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        var vi = convertView
        val holder: ViewHolder
        try {
            if (convertView == null) {
                vi = inflater?.inflate(R.layout.contact_list_view, null)
                holder = ViewHolder()

                holder.display_name = vi?.findViewById(R.id.firstLine)
                //holder.display_number = vi?.findViewById(R.id.secondLine)


                vi?.tag  = holder

            } else {
                holder = vi?.tag as ViewHolder
            }
            val name = lPerson?.get(position)?.Fname + " "+ lPerson?.get(position)?.Lname
            holder.display_name?.text = name
            //holder.display_number?.text =lPerson?.get(position)?.number?.toString()


        } catch (e: Exception) {


        }

        return vi
    }

    companion object {
        private var inflater: LayoutInflater? = null
    }
}