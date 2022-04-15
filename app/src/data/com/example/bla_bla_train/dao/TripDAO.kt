package com.example.bla_bla_train.dao

import androidx.room.*
import com.example.bla_bla_train.model.Trip
import kotlinx.coroutines.flow.Flow

@Dao
interface TripDAO {

    @Query("SELECT * FROM trips ORDER BY time DESC")
    fun getTrips(): Flow<List<Trip>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trip: Trip)

    @Query("DELETE FROM trips")
    suspend fun deleteAll()

    @Query("DELETE FROM trips WHERE id = :id")
    suspend fun deleteById(id: Int)
}