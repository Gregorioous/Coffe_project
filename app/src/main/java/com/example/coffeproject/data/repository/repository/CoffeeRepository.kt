package com.example.coffeproject.data.repository.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.coffeproject.data.models.CoffeeModel
import com.example.coffeproject.data.repository.dataSource.CoffeeApiDataSource
import com.example.coffeproject.data.repository.dataSource.CoffeeDataSource
import com.example.coffeproject.domain.repository.CoffeeCall

class CoffeeRepository(private val coffeeDataSource: CoffeeDataSource,
private val coffeeApiDataSource: CoffeeApiDataSource):CoffeeCall
{


    override fun loadCoffee():LiveData<List<CoffeeModel>>{
        return coffeeDataSource.loadCoffee()
    }

    override suspend fun startMigration(context: Context){
        coffeeDataSource.clear()
        coffeeApiDataSource.startMigration(context)
    }
}