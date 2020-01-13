package com.github.harmittaa.mapscachetest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class OtherFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_other, container, false)
        val button = view.findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            val activity = activity as MapsActivity
            activity.goBack()
        }
        return view
    }
}