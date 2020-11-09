package com.example.perfectmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.perfectmovie.frames.ReleasesFragment
import com.example.perfectmovie.frames.TopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val releasesFragment = ReleasesFragment()
        val topFragment = TopFragment()

        makeCurrentFragment(releasesFragment)
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.newReleases -> makeCurrentFragment(releasesFragment)
                R.id.topFilms -> makeCurrentFragment(topFragment)
            }
            true
        }
    }


    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameSw, fragment)
            commit()
        }
}
