package com.example.bla_bla_train.repository

import androidx.annotation.WorkerThread
import com.example.bla_bla_train.dao.TripDAO
import com.example.bla_bla_train.model.Trip
import kotlinx.coroutines.flow.Flow

class TripRepository(private val dao: TripDAO) {

    val trips: Flow<List<Trip>> = dao.getTrips()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(trip: Trip) {
        dao.insert(trip)
    }
}