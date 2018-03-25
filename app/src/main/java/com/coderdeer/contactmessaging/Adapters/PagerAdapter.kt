package com.coderdeer.contactmessaging.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.coderdeer.contactmessaging.Fragments.ContactListFragment
import com.coderdeer.contactmessaging.Fragments.MessagingListFragment


/**
 * Created by qureshi on 25/03/18.
 */
class PagerAdapter(fm: FragmentManager, internal var mNumOfTabs: Int) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {

        return when (position) {
            0 -> ContactListFragment()
            1 -> MessagingListFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return mNumOfTabs
    }
}