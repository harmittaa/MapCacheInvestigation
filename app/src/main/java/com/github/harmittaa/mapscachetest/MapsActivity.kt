package com.github.harmittaa.mapscachetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity() {
    val isFirstGo = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val newFragment = MapFragment()

        val transaction = supportFragmentManager.beginTransaction().apply {
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            replace(R.id.container, newFragment)
            addToBackStack("mapFragment")
        }

        transaction.commit();
    }

    fun changeFragment() {
        val newFragment = OtherFragment()

        val transaction = supportFragmentManager.beginTransaction().apply {
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            replace(R.id.container, newFragment)
            addToBackStack("newFragment")
        }

        transaction.commit();

    }

    fun goBack() {

    }
}
