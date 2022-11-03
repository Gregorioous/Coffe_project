package com.example.coffeproject.domain.repository

import androidx.lifecycle.LiveData
import com.example.coffeproject.data.models.OrderLocalModel

interface OrderLocalCall {
    suspend fun insert(orderLocalModel: OrderLocalModel)

    fun loadOrder(): LiveData<List<OrderLocalModel>>

    suspend fun clear()
}