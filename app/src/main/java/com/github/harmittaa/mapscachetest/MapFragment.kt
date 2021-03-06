package com.github.harmittaa.mapscachetest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapFragment : Fragment(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null
    private lateinit var mapView: MapView
    private var mapFragment: SupportMapFragment? = null
    private var isFirstPassView = false
    private var isFirstPassFragment = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isFirstPassView = true
        isFirstPassFragment = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_maps, container, false)
        mapView = view.findViewById(R.id.map_view)
        mapView.onCreate(savedInstanceState)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        // two different listeners are needed to enable separation between the two maps
        mapFragment?.getMapAsync(FragmentMapReadyListener())
        mapView.getMapAsync(this)

        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            val activity = activity as MapsActivity
            activity.changeFragment()
        }
    }

    // callback for MapView
    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        if (isFirstPassView) {
            addMarkerAndMoveMap(googleMap)
            addPolylineToMap(googleMap)
            isFirstPassView = false
        }
    }

    // callback for SupportMapFragment
    inner class FragmentMapReadyListener : OnMapReadyCallback {
        override fun onMapReady(googleMap: GoogleMap?) {
            if (isFirstPassFragment) {
                addMarkerAndMoveMap(googleMap!!)
                addPolylineToMap(googleMap)
                isFirstPassFragment = false
            }
        }
    }

    private fun addPolylineToMap(googleMap: GoogleMap) {
        googleMap.addPolyline(
            PolylineOptions()
                .clickable(true)
                .add(
                    LatLng(-35.016, 143.321),
                    LatLng(-34.747, 145.592),
                    LatLng(-34.364, 147.891),
                    LatLng(-33.501, 150.217),
                    LatLng(-32.306, 149.248),
                    LatLng(-32.491, 147.309)
                )
        )
    }

    private fun addMarkerAndMoveMap(googleMap: GoogleMap) {
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}