package com.example.coffeproject.data.repository.repository

import androidx.lifecycle.LiveData
import com.example.coffeproject.data.localDB.OrderLocalDao
import com.example.coffeproject.data.models.OrderLocalModel
import com.example.coffeproject.domain.repository.OrderLocalCall

class OrderLocalRepository (private val orderLocalDao: OrderLocalDao
): OrderLocalCall {

    override suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalDao.insert(orderLocalModel)    }

    override fun loadOrder(): LiveData<List<OrderLocalModel>> {
        return orderLocalDao.loadOrder()    }

    override suspend fun clear() {
        orderLocalDao.clear()    }



}