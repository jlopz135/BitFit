package com.example.bitfit

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class ItemRepository(private val HealthDao: HealthDAO) {

    val allItems: LiveData<List<FoodItem>> = HealthDao.getAll()

    @WorkerThread
    fun insert(food: FoodItem) {
        HealthDao.insert(food)
    }
}