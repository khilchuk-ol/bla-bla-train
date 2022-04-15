package com.example.bla_bla_train.application

import android.app.Application
import com.example.bla_bla_train.BlaBlaTrainDatabase
import com.example.bla_bla_train.repository.TripRepository

class TripsApplication : Application() {

    val database by lazy { BlaBlaTrainDatabase.getDatabase(this) }
    val repository by lazy { TripRepository(database.tripDAO()) }
}