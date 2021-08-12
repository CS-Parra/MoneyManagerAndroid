package org.equipo18.money_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.equipo18.money_manager.fragments.AcountFragment
import org.equipo18.money_manager.fragments.CategoryFragment
import org.equipo18.money_manager.fragments.MovementFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.frAccount

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.frAccount -> {
                    val fragment = AcountFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.frMovement -> {
                    val fragment = MovementFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                R.id.frCategory -> {
                    val fragment = CategoryFragment.newInstance()
                    openFragment(fragment)
                    true
                }
                else -> false
            }
        }

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.flFragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}