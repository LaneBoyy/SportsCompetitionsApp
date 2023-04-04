package ru.laneboy.sportscompetitionsapp.domane

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
    }

    companion object {

        private const val MAPKIT_API_KEY = "0f59f418-349a-4b78-ba49-04ebddce4f5b"
    }
}