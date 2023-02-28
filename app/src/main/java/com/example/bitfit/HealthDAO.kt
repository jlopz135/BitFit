package com.example.bitfit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface HealthDAO {
    // Query to get all data from the table HealthData
    @Query("SELECT * FROM HealthData")
    fun getAll(): LiveData<List<FoodItem>>

    // Insert new item to the HealthData table
    @Insert
    fun insert(food: FoodItem)

    // Delete all data from HealthTable
    @Query("DELETE FROM HealthData")
    fun deleteAll()

    // Delete single item from table
    @Delete
    fun deleteItem(food: FoodItem)


}