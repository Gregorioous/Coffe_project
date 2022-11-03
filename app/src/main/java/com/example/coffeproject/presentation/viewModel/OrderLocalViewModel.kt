package com.example.coffeproject.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeproject.data.models.OrderLocalModel
import com.example.coffeproject.domain.useCase.OrderLocalUseCase
import kotlinx.coroutines.launch

class OrderLocalViewModel (private val orderLocalUseCase: OrderLocalUseCase): ViewModel() {


    fun startInsert(nameUser:String, phoneUser:String, description:String, totalPrice:String) {
        insert(
            OrderLocalModel(0, nameUser, phoneUser, description, totalPrice)
        )
    }

    private fun insert(orderLocalModel: OrderLocalModel) = viewModelScope.launch{

        orderLocalUseCase.insert(orderLocalModel)
    }

    val loadOrder = orderLocalUseCase.loadOrder()

    fun clearOrders() = viewModelScope.launch{

        orderLocalUseCase.clear()
    }



}