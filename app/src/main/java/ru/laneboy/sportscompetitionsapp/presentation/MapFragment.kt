package ru.laneboy.sportscompetitionsapp.presentation

import android.content.Context
import android.graphics.PointF
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.ObjectEvent
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.IconStyle
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.RotationType
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.mapkit.user_location.UserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView
import com.yandex.runtime.image.ImageProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.FragmentMapBinding

class MapFragment : Fragment(), UserLocationObjectListener {

    private var _binding: FragmentMapBinding? = null
    private val binding: FragmentMapBinding
        get() = _binding ?: throw RuntimeException("FragmentMapBinding == null")

    private var cameraLatitude = 0.0
    private var cameraLongitude = 0.0

    private var initialized = false

    private lateinit var mapObjects: MapObjectCollection
    private lateinit var userLocationLayer: UserLocationLayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initialize(requireActivity())
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMap()

        setInitialPosition()

        clickOnLocationButton()
    }

    private fun setMap() {
        binding.mapView.map.isRotateGesturesEnabled = true
        val mapKit = MapKitFactory.getInstance()
        mapKit.resetLocationManagerToDefault()
        userLocationLayer = mapKit.createUserLocationLayer(binding.mapView.mapWindow)
        userLocationLayer.isVisible = true
        userLocationLayer.isHeadingEnabled = false
        userLocationLayer.setObjectListener(this)
        mapObjects = binding.mapView.map.mapObjects.addCollection()
    }

    private fun setInitialPosition() {
        CoroutineScope(Dispatchers.Main).launch {
            while (cameraLatitude == 0.0) {
                delay(500)
            }
            setLocation()
        }
    }

    private fun initialize(context: Context) {
        if (initialized) {
            return
        }
        MapKitFactory.initialize(context)
        initialized = true
    }

    override fun onObjectAdded(userLocationView: UserLocationView) {
        userLocationView.arrow.setIcon(
            ImageProvider.fromResource(
                requireActivity(), R.drawable.ic_search_result
            )
        )
        val pinIcon = userLocationView.pin.useCompositeIcon()
        pinIcon.setIcon(
            "pin",
            ImageProvider.fromResource(requireActivity(), R.drawable.ic_search_result),
            IconStyle().setAnchor(PointF(0.5f, 0.5f))
                .setRotationType(RotationType.ROTATE)
                .setZIndex(1f)
                .setScale(0.5f)
        )
        setRoute(userLocationView)
    }

    private fun setRoute(userLocationView: UserLocationView) {
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                try {
                    val newLatitude = userLocationView.arrow.geometry.latitude
                    val newLongitude = userLocationView.arrow.geometry.longitude
                    if (!newLatitude.equals(0.0) || !newLongitude.equals(0.0)) {
                        cameraLatitude = newLatitude
                        cameraLongitude = newLongitude
                    }
                } catch (_: Exception) {
                }
                delay(3000)
            }
        }
    }

    private fun clickOnLocationButton() {
        binding.buttonFindLocation.setOnClickListener {
            setLocation()
        }
    }

    private fun setLocation() {
        val point = Point(cameraLatitude, cameraLongitude)
        if (!point.latitude.equals(0.0) && !point.longitude.equals(0.0)) {
            binding.mapView.map.move(
                CameraPosition(point, 14F, 0F, 0F)
            )
        }
    }

    override fun onObjectRemoved(userLocationView: UserLocationView) {
    }

    override fun onObjectUpdated(userLocationView: UserLocationView, p1: ObjectEvent) {
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapView.onStart()
    }

    override fun onPause() {
        super.onPause()
        MapKitFactory.getInstance().onStop()
        binding.mapView.onStop()
    }

    override fun onStop() {
        binding.mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = MapFragment()

        const val PERMISSIONS_REQUEST_FINE_LOCATION = 1
    }
}