package com.example.bitfit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ItemViewModel(application: Application): AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: ItemRepository
    val allItems: LiveData<List<FoodItem>>

    init {
        val HealthDao = AppDatabase.getDatabase(application, scope).healthDao()
        repository = ItemRepository(HealthDao)
        allItems = repository.allItems
    }

    fun insert(food: FoodItem) = scope.launch(Dispatchers.IO) {
        repository.insert(food)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}