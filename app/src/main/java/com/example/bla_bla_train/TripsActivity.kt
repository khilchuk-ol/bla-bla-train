package com.example.bla_bla_train

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bla_bla_train.adapter.TripListAdapter
import com.example.bla_bla_train.application.TripsApplication
import com.example.bla_bla_train.viewmodel.TripViewModel
import com.example.bla_bla_train.viewmodel.TripViewModelFactory
import com.example.lab1.R

class TripsActivity : AppCompatActivity() {
    private val tripViewModel: TripViewModel by viewModels {
        TripViewModelFactory((application as TripsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_trips)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = TripListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        tripViewModel.allTrips.observe(this) { trips ->
            trips?.let { adapter.submitList(it) }
        }
    }
}