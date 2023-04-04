package ru.laneboy.sportscompetitionsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import ru.laneboy.sportscompetitionsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        removeStatusBar()
        launchFragmentMatchList()
    }

    private fun launchFragmentMatchList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_main, MatchListFragment.newInstance())
            .commit()
    }

    private fun removeStatusBar() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
}