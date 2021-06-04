package com.dev.pokemongo


import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.dev.pokemongo.adapter.ViewPagerAdapter
import com.dev.pokemongo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       //  navController = findNavController(R.id.nav_host_fragment_content_main)
        val sectionsPagerAdapter = ViewPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
          val tabs: TabLayout = binding.tabs
         tabs.setupWithViewPager(viewPager)

    }
      /**  binding.customeTab.item2.setOnClickListener {

            // binding.customeTab.item1.setTextColor(def)
            binding.customeTab.item2.setTextColor(Color.BLACK)
            binding.customeTab.item3.setTextColor(Color.BLACK)
            val size = binding.customeTab.item2.width
            binding.customeTab.select.animate().x(size.toFloat()).duration = 100
            navController?.navigate(R.id.communityFragment)
        }
        binding.customeTab.item1.setOnClickListener {
            details_animation()

        }

        binding.customeTab.item3.setOnClickListener {
            //  binding.customeTab.item1.setTextColor(def)
            binding.customeTab.item3.setTextColor(Color.BLACK)
            //   binding.customeTab.item2.setTextColor(def)
            val size = binding.customeTab.item2.width * 2
            binding.customeTab.select.animate().x(size.toFloat()).duration = 100
            navController?.navigate(R.id.myTeamFragment)
        }

        binding.customeTab.item4.setOnClickListener {
            //  binding.customeTab.item1.setTextColor(def)
            binding.customeTab.item4.setTextColor(Color.BLACK)
            //   binding.customeTab.item2.setTextColor(def)
            val size = binding.customeTab.item3.width * 3
            binding.customeTab.select.animate().x(size.toFloat()).duration = 100
            navController?.navigate(R.id.capturedFragment)
        }

    fun details_animation() {
        binding.customeTab.select.animate().x(0F).duration = 100
        binding.customeTab.item1.setTextColor(Color.BLACK)
        // binding.customeTab.item2.setTextColor(def)
        // binding.customeTab.item3.setTextColor(def)
        navController?.navigate(R.id.exploreFragment)
    }  **/
}