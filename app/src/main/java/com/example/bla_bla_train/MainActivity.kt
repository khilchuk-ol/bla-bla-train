package com.example.bla_bla_train

import android.app.Activity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bla_bla_train.FormFragment.Companion.CREATE_TRIP_KEY
import com.example.bla_bla_train.application.TripsApplication
import com.example.bla_bla_train.model.Trip
import com.example.bla_bla_train.viewmodel.TripViewModel
import com.example.bla_bla_train.viewmodel.TripViewModelFactory
import com.example.lab1.R

class MainActivity : AppCompatActivity() {
    private val tripViewModel: TripViewModel by viewModels {
        TripViewModelFactory((application as TripsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val formFr = FormFragment()
            formFr.createTripListener = { trip ->
                tripViewModel.insert(trip)
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, formFr)
                .add(R.id.fragment_container_view, TripInfoFragment::class.java, null)
                .add(R.id.fragment_container_view, HistoryBtnFragment::class.java, null)
                .commit()
        }
    }
}