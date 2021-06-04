package com.dev.pokemongo.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dev.pokemongo.R
import com.dev.pokemongo.ui.captured.CapturedFragment
import com.dev.pokemongo.ui.community.CommunityFragment
import com.dev.pokemongo.ui.explore.ExploreFragment
import com.dev.pokemongo.ui.myteam.MyTeamFragment

private val TAB_TITLES = arrayOf(
    R.string.explore,
    R.string.community,
    R.string.my_Team,
    R.string.captured
)

class ViewPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = ExploreFragment()
            1 -> fragment = CommunityFragment()
            2 -> fragment = MyTeamFragment()
            3 -> fragment = CapturedFragment()
        }
        return fragment!!
       // return PlaceholderFragment.newInstance(position + 1)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }
}