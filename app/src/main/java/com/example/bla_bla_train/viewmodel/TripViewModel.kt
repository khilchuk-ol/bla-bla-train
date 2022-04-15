package com.example.bla_bla_train.viewmodel

import androidx.lifecycle.*
import com.example.bla_bla_train.model.Trip
import com.example.bla_bla_train.repository.TripRepository
import kotlinx.coroutines.launch

class TripViewModel(private val repository: TripRepository) : ViewModel() {

    val allTrips: LiveData<List<Trip>> = repository.trips.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(trip: Trip) = viewModelScope.launch {
        repository.insert(trip)
    }
}

class TripViewModelFactory(private val repository: TripRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TripViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TripViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}