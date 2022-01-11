package ru.fefu.activitytracker.mainScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.fefu.activitytracker.R
import androidx.fragment.app.add
import androidx.fragment.app.commit

private const val profileFragment = "profile"
private const val physicalActivityFragment = "physical"

// Активити с основным экраном
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<PhysicalActivityFragment>(R.id.fragment_container, physicalActivityFragment)
                add<ProfileFragment>(R.id.fragment_container, profileFragment)
            }
            supportFragmentManager.executePendingTransactions();
            supportFragmentManager.commit {
                val fr = supportFragmentManager.findFragmentByTag(profileFragment)
                if (fr != null)
                    hide(fr)
            }
        }

        val bottomNavi = findViewById<BottomNavigationView>(R.id.bottomNavi)
        bottomNavi.setOnItemSelectedListener {
            supportFragmentManager.commit {
                val profileFragment = supportFragmentManager.findFragmentByTag(profileFragment)
                val physicalActivityFragment =
                    supportFragmentManager.findFragmentByTag(physicalActivityFragment)

                if (it.itemId == R.id.profile) {
                    if (profileFragment != null)
                        show(profileFragment)
                    if (physicalActivityFragment != null)
                        hide(physicalActivityFragment)
                } else {
                    if (profileFragment != null)
                        hide(profileFragment)
                    if (physicalActivityFragment != null)
                        show(physicalActivityFragment)
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}