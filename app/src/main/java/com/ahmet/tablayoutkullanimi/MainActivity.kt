package com.ahmet.tablayoutkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentListesi = ArrayList<Fragment>()
    private val fragmentBaslikListesi = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentListesi.add(FragmentBirinci())
        fragmentListesi.add(FragmentIkinci())
        fragmentListesi.add(FragmentUcuncu())

        val adapter = MyViewPagerAdapter(this)
        viewpager2.adapter = adapter

        fragmentBaslikListesi.add("bir")
        fragmentBaslikListesi.add("iki")
        fragmentBaslikListesi.add("uc")

        TabLayoutMediator(tablayout,viewpager2){tab, position ->
            tab.setText(fragmentBaslikListesi[position])

        }.attach()

        tablayout.getTabAt(2)!!.setIcon(R.drawable.resim)
        tablayout.getTabAt(1)!!.setIcon(R.drawable.run)
        tablayout.getTabAt(0)!!.setIcon(R.drawable.swim)
    }

    inner class MyViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){
        override fun getItemCount(): Int {
            return fragmentListesi.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragmentListesi[position]
        }

    }
}