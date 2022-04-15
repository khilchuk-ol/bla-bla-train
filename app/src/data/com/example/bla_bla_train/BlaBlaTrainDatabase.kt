package com.example.bla_bla_train

import android.content.Context
import androidx.room.*
import com.example.bla_bla_train.dao.TripDAO
import com.example.bla_bla_train.model.Trip

@Database(entities = [Trip::class], version = 1, exportSchema = false)
abstract class BlaBlaTrainDatabase : RoomDatabase() {

    abstract fun tripDAO(): TripDAO

    companion object {
        @Volatile
        private var INSTANCE: BlaBlaTrainDatabase? = null

        fun getDatabase(context: Context): BlaBlaTrainDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BlaBlaTrainDatabase::class.java,
                    "blablatrain_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}