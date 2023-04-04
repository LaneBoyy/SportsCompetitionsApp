package ru.laneboy.sportscompetitionsapp.presentation

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.yandex.mapkit.MapKitFactory
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        removeStatusBar()
        requestLocationPermission()
        setBottomNavigation()

    }

    private fun setBottomNavigation() {
        setFragment(MatchListFragment.newInstance())
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.match_list -> {
                    setFragment(MatchListFragment.newInstance())
                }
                R.id.map -> {
                    setFragment(MapFragment.newInstance())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_main, fragment)
            .commit()
    }

    private fun removeStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }

    private fun requestLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                "android.permission.ACCESS_FINE_LOCATION"
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf("android.permission.ACCESS_FINE_LOCATION"),
                MapFragment.PERMISSIONS_REQUEST_FINE_LOCATION
            )
        }
    }
}