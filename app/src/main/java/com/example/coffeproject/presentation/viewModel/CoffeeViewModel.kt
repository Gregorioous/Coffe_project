package com.example.coffeproject.presentation.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.example.coffeproject.data.models.CoffeeModel
import com.example.coffeproject.domain.repository.CoffeeCall
import com.example.coffeproject.domain.useCase.CoffeeUseCase
import kotlinx.coroutines.launch

class CoffeeViewModel (private val coffeeUseCase: CoffeeUseCase):ViewModel() {
    val loadCoffee = coffeeUseCase.loadCoffee()

     fun startMigration(context: Context) = viewModelScope.launch {
         coffeeUseCase.startMigration(context)
     }
}