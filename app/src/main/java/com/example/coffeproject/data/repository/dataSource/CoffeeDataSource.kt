package com.example.coffeproject.data.repository.dataSource

import androidx.lifecycle.LiveData
import com.example.coffeproject.data.models.CoffeeModel

interface CoffeeDataSource {
    fun insert (coffeeModel: CoffeeModel)

    fun loadCoffee(): LiveData<List<CoffeeModel>>

    suspend fun clear()
}