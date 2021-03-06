package com.example.msise.journeyplanner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.msise.journeyplanner.network.ApiClient
import com.example.msise.journeyplanner.network.ApiInterface
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import com.example.msise.journeyplanner.collections.CollectionsFragment
import com.example.msise.journeyplanner.search.SearchFragment
import com.example.msise.journeyplanner.settings.SettingsFragment


class MainActivity : AppCompatActivity() {

    lateinit var toolbar: ActionBar

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.menu_bottom_search -> {
                val fragment: Fragment = SearchFragment.newInstance()
                openFragment(fragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_bottom_collections -> {
                val fragment: Fragment = CollectionsFragment.newInstance()
                openFragment(fragment)

                return@OnNavigationItemSelectedListener true
            }
            R.id.menu_bottom_settings -> {
                val fragment: Fragment = SettingsFragment.newInstance()
                openFragment(fragment)

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val endPoint = ApiClient().getClient().create(ApiInterface::class.java)

        toolbar = supportActionBar!!

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.activity_main_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.activity_main_frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
