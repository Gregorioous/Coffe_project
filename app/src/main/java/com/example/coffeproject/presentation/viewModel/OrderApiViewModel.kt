package com.example.coffeproject.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeproject.domain.useCase.OrderApiUseCase
import kotlinx.coroutines.launch

class OrderApiViewModel (private val orderApiUseCase: OrderApiUseCase): ViewModel() {

    fun insert(context: Context, name:String, phone:String, description:String, priceOrder:String) = viewModelScope.launch {
        orderApiUseCase.insert(context, name, phone, description, priceOrder)

    }
}