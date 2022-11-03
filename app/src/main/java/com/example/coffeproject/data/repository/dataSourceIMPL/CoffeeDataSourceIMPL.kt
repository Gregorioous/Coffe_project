package com.example.coffeproject.data.repository.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.example.coffeproject.data.localDB.CoffeeDao
import com.example.coffeproject.data.models.CoffeeModel
import com.example.coffeproject.data.repository.dataSource.CoffeeDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoffeeDataSourceIMPL (private val dao: CoffeeDao):
    CoffeeDataSource {


    override fun insert(coffeeModel: CoffeeModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(coffeeModel)}
    }

    override fun loadCoffee(): LiveData<List<CoffeeModel>> {
        return dao.loadCoffee()
    }


    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }



}