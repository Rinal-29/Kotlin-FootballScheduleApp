package com.rinal.submission2.leagues

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rinal.submission2.match.nextmatch.NextMatchFragment
import com.rinal.submission2.match.prevmatch.PreviousMatchFragment

class PagerAdapter (private val fm : FragmentManager, private val context: Context) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> NextMatchFragment()
            else -> PreviousMatchFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Next Match"
            else -> "Previous Match"
        }
    }
}