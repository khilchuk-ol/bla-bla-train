package com.example.bla_bla_train.model

import androidx.room.*

@Entity(tableName = "trips")
class Trip(
    @ColumnInfo(name = "from") val from: String,
    @ColumnInfo(name = "to") val to: String,
    @ColumnInfo(name = "time") val time: String,

    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)