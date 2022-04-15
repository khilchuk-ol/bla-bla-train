package com.example.bla_bla_train

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bla_bla_train.FormFragment.Companion.CREATE_TRIP_KEY
import com.example.lab1.R

class TripInfoFragment : Fragment(R.layout.fragment_trip_info) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tripInfo = view.findViewById<TextView>(R.id.tripInfo)

        parentFragmentManager.setFragmentResultListener(CREATE_TRIP_KEY, viewLifecycleOwner) { _, result ->
            tripInfo.text = result["msg"].toString()
        }
    }
}